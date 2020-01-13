/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2019/12/24
 * Time: 2:53 PM
 */
public class PrimeThread extends Thread {
    private long minTime;

    PrimeThread(long minTime) {
        this.minTime = minTime;
    }

    public void run() {
        System.out.println("start run");
        System.out.println(this.minTime);
    }
}
