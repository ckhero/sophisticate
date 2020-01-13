import java.sql.Time;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/1/13
 * Time: 5:49 PM
 */
public class Fibonacci {

    public static void main(String[] args) throws Exception {
//        System.out.println(fibRec(1));
//        System.out.println(fibRec(2));
//        System.out.println(fibRec(3));
//        System.out.println(fibRec(4));
//        System.out.println(fibRec(5));
//        System.out.println(fibRec(6));

        Date startRec =  new Date();

        System.out.println(fibRec(80));

        Date endRec =  new Date();
//        System.out.println(fibUnRec(1));
//        System.out.println(fibUnRec(2));
//        System.out.println(fibUnRec(3));
//        System.out.println(fibUnRec(4));
//        System.out.println(fibUnRec(5));
//        System.out.println(fibUnRec(6));
        System.out.println(fibUnRec(80));

        Date endUnRec =  new Date();
        System.out.println("Rec cost =" + (endRec.getTime() - startRec.getTime()));
        System.out.println("UnRec cost =" + (endUnRec.getTime() - endRec.getTime()));
    }

    public static long fibRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibRec(n-1) + fibRec(n - 2);
    }

    public static long fibUnRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
