package zjy.web.Filterselect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/getip")
public class getip extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getRemoteAddr();
        PrintWriter ut = resp.getWriter();
        resp.setContentType("text/html;charset=utf-8");
        ut.println("你的IP地址为" + ip);



    }
}
