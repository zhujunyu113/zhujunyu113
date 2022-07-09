import org.junit.Test;
public class Textobj {
    @Test
    public void text(){
        Object i=new Object();
        Object o=i;
        i=null;

        System.out.println(o);

    }
}
