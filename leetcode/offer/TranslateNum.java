/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/14
 * Time: 4:38 PM
 */

/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class TranslateNum {
    public static void main(String[] args) {
//        char aa = (int)('1' + '1');
        System.out.println((new TranslateNum()).translateNum(25));
        System.out.println((int)('1' - '0' + '1' - '0'));
    }
    int ans = 0;
    public int translateNum(int num) {
        helper(String.valueOf(num).toCharArray(), 0);
        return ans;
    }

    private void helper(char[] nums, int start) {
        int len = nums.length;
        if (len == start) {
            ans++;
            return;
        }
        helper(nums, start + 1);
        if (start + 1 < len && nums[start] <= '2' && nums[start] != '0') {
            int curr = (nums[start] - '0') * 10 + nums[start + 1] - '0';
            if (curr <= 25) {
                helper(nums, start + 2);
            }
        }
    }

    public int dp(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int len = nums.length;
        if (len <= 1) {
            return len;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len ; i++) {
            int tmp = dp[i];
            if (nums[i - 1] <= '2' && nums[i - 1] != '0') {
                int curr = (nums[i - 1] - '0') * 10 + nums[i] - '0';
                if (curr <= 25) {
                    tmp += dp[i - 1];
                }
            }
            dp[i + 1] = tmp;
        }
        return dp[len];
    }
}
