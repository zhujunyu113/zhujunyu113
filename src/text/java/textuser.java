import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zjy.web.Mappers.hotelMapper;
import zjy.web.Mappers.userMapper;
import zjy.web.bin.User;
import zjy.web.bin.hotelObj;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class textuser {
    @Test
    public void textUser() throws IOException {
        InputStream sql= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQlsessionFActory工厂
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(sql);
        //获取SQLsession对象
        SqlSession sqlSession=factory.openSession();

        //完成查询操作
        //动态代理解析hotelMapper.xml文件,返回hotelMapper接口(动态代理对象),通过接口方法获取
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //查询结果返回对象集合
        List<User> user = mapper.getUser(new User("roo","root"));
        System.out.println("--------"+user.isEmpty());
        user.forEach(user1 -> System.out.println(user1));
        //关闭
        sqlSession.close();

    }
}
