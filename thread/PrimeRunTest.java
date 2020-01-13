
/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2019/12/24
 * Time: 2:57 PM
 */
public class PrimeRunTest {
    public static void main(String[] args) throws Exception{
        PrimeRun p = new PrimeRun(1000);
        new Thread(p).start();
        new Thread(p).start();
    }
}
