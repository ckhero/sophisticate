package zijie;

public class FindKthNumber {
    public static void main(String[] args) {

        System.out.println(findKthNumber(20, 11));
    }
    private static int findKthNumber(int n, int k) {
        int pre = 1;
        int index = 1;
        while (index < k) {
            int count = count(pre, n);
            if (index + count > k) {
                pre *= 10;
                index++;
            } else {
                pre++;
                index += count;
            }
        }
        return pre;
    }

    private static int count(int pre, int n) {
        int count = 0;
        long curr = pre;
        long next = pre + 1;
        while (curr <= n) {
            count += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }
        return count;
    }
}
