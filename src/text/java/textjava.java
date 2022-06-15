import org.junit.Test;

import java.util.Date;

public class textjava {
    @Test
 public void gettime(){
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);
        Date date1=new Date(1654644874669L);
        System.out.println(date1);


    }
}
