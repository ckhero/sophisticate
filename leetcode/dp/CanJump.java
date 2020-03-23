package dp;

/**
 * f(k)
 * f(1) = a1(a1 > len)
 * f(2) = (f(1) + a2) > len
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    enum Index {
        GOOD, BAD, UNKNOW
    }
    private static boolean canJump(int[] nums) {
        int len = nums.length;
        Index[] memo = new Index[len];
        for (int i = 0; i < len; i++) {
            memo[i] = Index.UNKNOW;
        }
        memo[len - 1] = Index.GOOD;
        for (int i = len - 2; i >= 0 ; i--) {
            int furthestJump = Math.min(i + nums[i], len - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                }
            }
        }
        return memo[0] == Index.GOOD;
    }
}
