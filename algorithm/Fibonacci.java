/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/1/13
 * Time: 5:49 PM
 */
public class Fibonacci {

    public static void main(String[] args) throws Exception {
        System.out.println(fibRec(1));
        System.out.println(fibRec(2));
        System.out.println(fibRec(3));
        System.out.println(fibRec(4));
        System.out.println(fibRec(5));
        System.out.println(fibRec(6));
        System.out.println(fibRec(7));

        System.out.println(fibUnRec(1));
        System.out.println(fibUnRec(2));
        System.out.println(fibUnRec(3));
        System.out.println(fibUnRec(4));
        System.out.println(fibUnRec(5));
        System.out.println(fibUnRec(6));
        System.out.println(fibUnRec(7));
    }

    public static int fibRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibRec(n-1) + fibRec(n - 2);
    }

    public static int fibUnRec(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        int res = 0;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }
}
