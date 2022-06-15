package zjy.web.Filterselect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/exit")
public class exit extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();//摧毁Session
        //删除Cookie
        Cookie[] cookies=req.getCookies();
        for (Cookie cooike:cookies) {
            cooike.setMaxAge(0);
            resp.addCookie(cooike);

        }
        //重定向
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
