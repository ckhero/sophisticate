package ptr;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 通过次数20,405提交次数45,968
 */
public class SubarraySum {
    public static void main(String[] args) {
        char a = 'b';
        System.out.println(a > 'a');
//        int[] nums = new int[]{1,1,1};
//        int[] nums = new int[]{1,2,1,2,1};
//        int[] nums = new int[]{1};
        int[] nums = new int[]{-1,-1,1};
//        int[] nums = new int[]{1,2,3};
        System.out.println((new SubarraySum()).subarraySum(nums, 0));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        int sum = 0;
        count.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (count.containsKey(sum - k)) {
                ans += count.get(sum - k);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
