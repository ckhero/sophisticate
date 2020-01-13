/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2019/12/24
 * Time: 2:56 PM
 */
public class PrimeRun implements Runnable {
    private long minTime;

    PrimeRun(long minTime) {
        this.minTime = minTime;
    }

    public void run() {
        System.out.println("runnable start run");
        System.out.println(this.minTime);
    }
}
