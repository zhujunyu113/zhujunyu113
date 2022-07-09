package zjy.web.Filterselect;

import jakarta.servlet.*;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



@WebServlet("/hotel")
public class hotel extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");


        PrintWriter out =resp.getWriter();


        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet re=null;
        try {
            //注册驱动
            ServletContext servletContext = getServletContext();
            String driver ="com.mysql.cj.jdbc.Driver";
            Class.forName(driver);

            String url="jdbc:mysql://localhost:3306/zjy";
            String user="root";
            String password="root";

            //获取链接
            conn= DriverManager.getConnection(url,user,password);
            //获取预编译的SQL语句执行对象
            ps=conn.prepareStatement("select * from hotel;");
            //执行SQL语句
            re = ps.executeQuery();
            out.print("房间号,房间状态，房间类型<br>");

            while (re.next()){
                out.print(re.getString("roomno"));
                out.print(re.getString("hotel_status").equals("False") ? "未入住" : "已入住");
                out.print(re.getString("room_type"));
                out.print("<br>");
            }
            //释放资源
            if (re != null) {
                re.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        out.println("<a href=\"exit\">退出登录</a>");


    }


}
