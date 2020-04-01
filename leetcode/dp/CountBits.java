package dp;

import java.util.Arrays;

/**
 *338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 *
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 *
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 通过次数31,440提交次数41,998
 */
public class CountBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new CountBits()).countBits(5)));
    }
    public int[] countBits(int num) {
        //m每道 2^n 的时候 1为1个
        // 记上一个2n 为curr
        // dp[n] = dp[curr] + dp[n - curr]
        if (num == 0) {
            return new int[]{0};
        }
        if (num == 1) {
            return new int[]{0, 1};
        }
        int[] dp = new  int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int currStart = dp[1];
        for (int curr = 2; curr <= num; curr++) {
            if (curr / 2 == currStart) {
                dp[curr] = 1;
                currStart = curr;
                continue;
            }
            dp[curr] = dp[currStart] + dp[curr - currStart];
        }
        return dp;
    }
}
