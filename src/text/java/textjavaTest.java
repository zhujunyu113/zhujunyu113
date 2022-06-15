import org.junit.Test;
import org.junit.Assert;

public class textjavaTest{
    @Test
    public void textjava() throws InterruptedException {
        System.out.println("睡10秒");
        Thread.sleep(99);
        Assert.assertEquals("0",new String("0"));

    }

}