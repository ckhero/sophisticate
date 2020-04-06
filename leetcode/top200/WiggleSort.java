package top200;

/**
 * https://leetcode-cn.com/problems/wiggle-sort/
 * 280. 摆动排序
 * 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。
 *
 * 示例:
 *
 * 输入: nums = [3,5,2,1,6,4]
 * 输出: 一个可能的解答是 [3,5,1,6,2,4]
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 ) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i+1);
                }
            } else {
                if (nums[i] < nums[i + 1]) {
                    swap(nums, i, i+1);
                }
            }
        }
    }
    private  void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
