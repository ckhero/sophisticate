/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/23
 * Time: 4:01 PM
 */

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 通过次数41,643提交次数123,002
 */
public class Jump {
    public static void main(String[] args) {

        int[] nums = new int[]{2,3,1,1,4};
        System.out.println((new Jump()).jump(nums));
        System.out.println();
    }
    public int jump(int[] nums) {
        int end = 0; //每一步的边界
        int maxPos = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, nums[i] + i);
            if (i == end) {
                steps++;
                end = maxPos;
            }
        }
        return steps;
    }

    // 顺藤摸瓜 O(n2)
    public int jump2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] memo = new int[len];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int i = 0; i < len; i++) {
            int max = Math.min(i + nums[i], len - 1);
            for (int j = i + 1; j <= max; j++) {
                memo[j] = Math.min(memo[j], memo[i] + 1);
            }
        }
        return memo[len - 1];
    }
}
