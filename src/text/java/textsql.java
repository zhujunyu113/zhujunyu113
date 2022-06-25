import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zjy.web.Mappers.hotelMapper;
import zjy.web.bin.hotelObj;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class textsql {
    @Test
    public void texthotel() throws IOException {
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
        //遍历集合输出
        hotelObj.forEach((hotelObj1 -> System.out.println("房间号"+ hotelObj1.getRoomno()+"房间状态"+hotelObj1.getHotel_status()+"房间类型"+hotelObj1.getRoom_type())));

        //关闭
        sqlSession.close();


    }
    @Test
    public void textobj(){
     int s=111;
        System.out.println(s);

    }
}
