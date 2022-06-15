package zjy.web.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;


public class loginfilter implements Filter {
    public boolean cookielogin(HttpServletRequest req, HttpServletResponse resp,FilterChain filterChain) throws ServletException, IOException {
        //如果没有登录,就验证cookie登录
        Cookie[] cookie=req.getCookies();
        ServletContext servletContext = req.getServletContext();
        //准备用户名和密码
        String name=null,passwor=null;
        Cookie cookie0=null,cookie2=null;
        if(cookie!=null){
        for (Cookie cookie1:cookie) {

            if("username".equals(cookie1.getName())){
                //如果这个cookie是用户名,就保存
                name=cookie1.getValue();
                cookie0=cookie1;
            }else if("password".equals(cookie1.getName())){
                passwor=cookie1.getValue();
                cookie2=cookie1;
                //如果是密码，保存
            }

        }}else return false;

        if(name==null||passwor==null){
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return false;

        }else if(login(name,passwor,servletContext)){
            HttpSession session = req.getSession();
            session.setAttribute("username",name);
            cookie0.setMaxAge(60*60*24*2);//自动续2天的有效期
            cookie2.setMaxAge(60*60*24*2);
            resp.addCookie(cookie0);
            resp.addCookie(cookie2);
            //跳转到资源
            resp.sendRedirect(req.getContextPath()+"/hotel");
            return true;




        }else{
            cookie0.setMaxAge(0);//失败说明cookie无效，删除cookie
            cookie2.setMaxAge(0);
            resp.addCookie(cookie0);
            resp.addCookie(cookie2);
            return false;
        }

    }

    //由此过滤器验证登录

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        if(""req.getContextPath())

        HttpSession session = req.getSession();
        Object username = session.getAttribute("username");
        if("/index.jsp".equals(req.getServletPath())){
          //如果是登录页，且没有登录,就登录，登录了就跳转
            if(username==null){
                if(!cookielogin(req,resp,filterChain)) {
                    //如果当前没有登陆，尝试使用cookie登录，如果登录失败就跳转到登录
                    filterChain.doFilter(servletRequest, servletResponse);
                }
            }else resp.sendRedirect("/hotel");

          return;
      }else if(username != null) {
            //如果访问的不是登录页，验证登录,已登录继续，未登录进行登录
            filterChain.doFilter(req, resp);
            return;
        }






        //程序走到这里说明需要登录
        ServletContext servletContext = req.getServletContext();
        String username1 = req.getParameter("username");
        String password = req.getParameter("password");
        if(username1!=null&&password!=null&&login(username1, password,servletContext)){
            //登录成功,向会话域中添加数据,跳转至资源
            session.setAttribute("username",username1);
            //Cookie[] cookie=req.getCookies();
           if( "1".equals(req.getParameter("autologin"))){
               //如果选择了"下次自动登录"的选项,就添加cookie
               Cookie ps=new Cookie("password",password),user=new Cookie("username",username1);
               ps.setMaxAge(60*60*24*2);//设置有效期为2天
               user.setMaxAge(60*60*24*2);//设置有效期为2天
               ps.setPath(req.getContextPath());//只要是这个项目就统统有效
               user.setPath(req.getContextPath());
               resp.addCookie(ps);
               resp.addCookie(user);

           }

            filterChain.doFilter(req,resp);

        }else {
           // PrintWriter out = resp.getWriter();
           // req.setCharacterEncoding("utf-8");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            //out.println("<h3>登录失败,可能是用户名或密码错误,<a href=\""+req.getContextPath()+"index.jsp\">请重试!</h3>");
        }
























    }
    public boolean login(String username,String password,ServletContext servletContext){
        Connection conn=null;
        //连接
        PreparedStatement ps=null;
        //数据库连接对象
        ResultSet rs=null;
        //结果集

        //用户是否登录成功
        try {
            //注册驱动
            String driver = servletContext.getInitParameter("Driver");
            Class.forName(driver);
            //获取连接
            String url=servletContext.getInitParameter("url");
            String user=servletContext.getInitParameter("user");
            String password1=servletContext.getInitParameter("password");
            conn= DriverManager.getConnection(url,user,password1);
            //获取数据库操作对象
            ps= conn.prepareStatement("select * from user where name =? and password =? ;");
            //执行sql语句
            ps.setString(1,username);
            ps.setString(2,password);
            rs=ps.executeQuery();
            //处理结果集
            while (rs.next()){
                return true;
                //如果有结果集代表登录成功,返回true
            }
            //如果没有结果集代表登录失败,返回false
            return false;

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            //释放资源
            try{
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }

            }catch (SQLException e){
                throw  new RuntimeException(e);
            }
        }

    }


}
