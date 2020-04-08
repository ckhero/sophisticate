/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/8
 * Time: 1:18 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] ans = (new MaxSlidingWindow()).maxSlidingWindow(nums, 3);
        System.out.println();
    }
    ArrayDeque<Integer> queue = new ArrayDeque<>();

    public void cleanDqueue(int i, int k, int[] nums) {
        while (!queue.isEmpty() && queue.getFirst() == i - k) {
            queue.removeFirst();
        }

        while (!queue.isEmpty() && nums[queue.getLast()] < nums[i]) {
            queue.removeLast();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len * k == 0) {
            return new int[]{};
        }
        if (len == 1) {
            return nums;
        }
        int[] ans = new int[len - k + 1];

        for (int i = 0; i < len; i++) {
            cleanDqueue(i, k, nums);
            queue.addLast(i);
            if (i + 1 >= k) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }
}
