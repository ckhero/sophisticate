package str;

public class ReverseInterger {
    public static void main(String[] args) {
        System.out.println(reverse(-999));
    }
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -7)) {
                return 0;
            }
            int temp = rev * 10 + pop;
            rev = temp;
        }

        return rev;
    }
}
