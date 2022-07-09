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
        //����SQlsessionFActory����
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(sql);
        //��ȡSQLsession����
        SqlSession sqlSession=factory.openSession();

        //��ɲ�ѯ����
        //��̬�������hotelMapper.xml�ļ�,����hotelMapper�ӿ�(��̬�������),ͨ���ӿڷ�����ȡ
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        //��ѯ������ض��󼯺�
        List<User> user = mapper.getUser(new User("roo","root"));
        System.out.println("--------"+user.isEmpty());
        user.forEach(user1 -> System.out.println(user1));
        //�ر�
        sqlSession.close();

    }
}
