import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import zjy.web.Mappers.hotelMapper;
import zjy.web.bin.hotelObj;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
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
    //生成记录条数

    public void textobj(){
        Connection conn=null;
        PreparedStatement st=null;
        //ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://192.168.0.78:3306/zjy","zjy","zjy");
            st=conn.prepareStatement("insert into hotel ( roomno, hotel_status, room_type) VALUES (?,?,?);");
            for(int x=1;x<=10;x++){
                for(int y=1;y<=10;y++){
                    String s=null;
                    if(y<=5){
                        s="大床房";

                    }else s="双人房";
                    int i=(x*100)+y;
                    st.setInt(1,i);
                    st.setString(2,"False");
                    st.setString(3,s);
                    st.executeUpdate();


                }

            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}
