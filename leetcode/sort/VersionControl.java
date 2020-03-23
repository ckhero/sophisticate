package sort;

public class VersionControl {

    public static void main(String[] args) {
            System.out.println(firstBadVersion(10));
    }

    private static int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    private static boolean isBadVersion(int n) {
        if (n > 5) {
            return true;
        }
        return false;
    }
}
