package zjy.web.Filterselect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/exit"})
public class exit extends HttpServlet {
    public exit() {
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        Cookie[] cookies = req.getCookies();
        Cookie[] var4 = cookies;
        int var5 = cookies.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Cookie cooike = var4[var6];
            cooike.setMaxAge(0);
            resp.addCookie(cooike);
        }

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
