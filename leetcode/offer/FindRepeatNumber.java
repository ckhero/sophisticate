package offer;

import java.util.HashSet;

/**
 * 面试题03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == nums[curr]) {
                return curr;
            }
            nums[i] = nums[curr];
            nums[curr] = curr;
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int currLeft = nums[left++];
            int currRight = nums[right--];
            if (currLeft == currRight) {
                return currLeft;
            }
            if (set.contains(currLeft)) {
                return currLeft;
            }
            if (set.contains(currRight)) {
                return currRight;
            }
            set.add(currRight);
            set.add(currLeft);
        }
        return 0;
    }
}
