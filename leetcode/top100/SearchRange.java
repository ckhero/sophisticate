/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/7
 * Time: 3:29 PM
 */

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchRange {
    public static void main(String[] args) {

//        int[] nums = new int[]{5,7,7,8,8,10};
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] ans = (new SearchRange()).searchRange(nums, 8);
        System.out.println(Arrays.toString(ans));
    }
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
    int left = 0;
    int right = len;
    //利用二分查找来搜索 左边界
        while (left < right) {
        //避免 right left 过大 越界
        int mid = left + (right - left) / 2;
        int curr = nums[mid];
        if (curr == target) {
            right = mid;
        } else if (curr < target){
            left = mid + 1;
        } else if (curr > target) {
            right = mid;
        }
    }
    int leftIdx = (left >= len) || nums[left] != target ? - 1 : left;

    left = 0;
    right = len;
        while (left < right) {
        int mid = left + (right - left) / 2;
        int curr = nums[mid];
        if (curr == target) {
            left = mid + 1;
        } else if (curr < target){
            left = mid + 1;
        } else if (curr > target) {
            right = mid;
        }
    }

    int rightIdx =  left == 0 || (left >= len) || nums[left - 1] != target ? - 1 : left - 1;
        return new int[]{leftIdx, rightIdx};
}
}
