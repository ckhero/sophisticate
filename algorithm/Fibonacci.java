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
        System.out.println(fastPower(2, 9));
//        System.out.println(fibRec(2));
//        System.out.println(fibRec(3));
//        System.out.println(fibRec(4));
//        System.out.println(fibRec(5));
//        System.out.println(fibRec(6));

        Date startRec =  new Date();

//        System.out.println(fibRec(20));

        Date endRec =  new Date();
        System.out.println("Rec cost =" + (endRec.getTime() - startRec.getTime()));

//        System.out.println(fibUnRec(1));
//        System.out.println(fibUnRec(2));
//        System.out.println(fibUnRec(3));
//        System.out.println(fibUnRec(4));
//        System.out.println(fibUnRec(5));
//        System.out.println(fibUnRec(6));
        System.out.println(fibUnRec(80));

        Date endUnRec =  new Date();
        System.out.println("UnRec cost =" + (endUnRec.getTime() - endRec.getTime()));
    }

    /**
     * 递归 大量重复的计算  效率低下
     * @param n
     * @return
     */
    private static long fibRec(int n) {
        return n < 2 ? 1 : fibRec(n-1) + fibRec(n - 2);
    }

    /**
     * 非递归
     * @param n
     * @return
     */
    private static long fibUnRec(int n) {
        if (n < 3) {
            return 1;
        }
        long[] fib = new long[n];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n - 1];
    }

    public static int fastPower(int a, int b) {
        int ans = 1;
        int base = a;
        while (b != 0) {
            if ((b & 1) != 0) { //如果当前的次幂数最后一位(二进制数)不为0的话，那么我们将当前权值加入到最后答案里面去
                ans = ans * base;
            }
            //权值增加
            base = base * base;
            b >>= 1;
        }
        return ans;
    }
}
