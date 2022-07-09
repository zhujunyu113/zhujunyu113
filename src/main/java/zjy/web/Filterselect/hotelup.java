package zjy.web.Filterselect;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import zjy.web.Mappers.hotelMapper;
import zjy.web.bin.hotelObj;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
@WebServlet("/hotelup")
public class hotelup extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //在此处进行数据访问并转发到jsp
        //使用文件流读取mybatis核心配置文件
        InputStream sql= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQlsessionFActory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(sql);
        //获取SQLsession对象
        SqlSession sqlSession=factory.openSession();

        //完成查询操作
        //动态代理解析hotelMapper.xml文件,返回hotelMapper接口(动态代理对象),通过接口方法获取
        hotelMapper mapper = sqlSession.getMapper(hotelMapper.class);
        //查询结果返回对象集合
        List<hotelObj> hotelObj = mapper.getAll();
        //关闭
        sqlSession.close();
        //遍历集合输出
        //获取上下文对象

        req.setAttribute("房间结果集合",hotelObj);
        //转发到jsp

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/hotel.jsp");
        requestDispatcher.forward(req,res);

    }
}
