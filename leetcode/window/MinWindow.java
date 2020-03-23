package window;

public class MinWindow {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

//    private static String minWindow(String s, String t) {
//
//    }
    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x !=0)) {
            return false;
        }
        int tmp = x;

        int revertedX = 0;
        while (tmp != 0) {
            revertedX = revertedX * 10 + tmp % 10;
            tmp /= 10;
        }
        return revertedX == x;
    }
}
