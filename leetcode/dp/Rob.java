package dp;

/**
 * f(k)
 * f(1) = a1
 * f(2) = max(a1,a2)
 * f(3) = max(f(1) + a3, f(2))
 * f(4) = max(f(2) + a4, f(3))
 */
public class Rob {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int[] res = new int[nums.length + 2];
        res[0] = 0;
        res[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i + 2] = Math.max(res[i] + nums[i], res[i+1]);
        }
        return res[nums.length + 1];
    }
}
