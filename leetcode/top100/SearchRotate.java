package top100;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchRotate {
    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        System.out.println((new SearchRotate()).search(nums, 0 ));
        System.out.println((new SearchRotate()).search(nums, 1 ));
        System.out.println((new SearchRotate()).search(nums, 2 ));
        System.out.println((new SearchRotate()).search(nums, 3 ));
        System.out.println((new SearchRotate()).search(nums, 4 ));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right < 0 || (target > nums[right] && target < nums[left])) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            int curr = nums[mid];
            int currLeft = nums[left];
            int currRight = nums[right];
            if (curr == target) {
                return mid;
            }
            //先判断结果左边还是右边，
            if (target <= currRight) {
                //然后判断 mid是在左边还是右边
                if (curr > currRight) {
                    left = mid + 1;
                } else {
                    //正常逻辑
                    if (curr > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                if (curr < currLeft) {
                    right = mid - 1;
                } else {
                    if (curr > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
