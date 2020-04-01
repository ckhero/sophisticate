package ptr;

/**
 * 713. 乘积小于K的子数组
 * 给定一个正整数数组 nums。
 *
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 *
 * 示例 1:
 *
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 *
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 * 通过次数5,171提交次数14,797
 */
public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        System.out.println((new NumSubarrayProductLessThanK()).numSubarrayProductLessThanK(nums, 100));
    }

    /**
     * 对于每个 \mathrm{right}right，我们需要找到最小的 \mathrm{left}left，满足 \prod_{i=\mathrm{left}}^\mathrm{right} \mathrm{nums}[i] < k∏
     * i=left
     * right
     * ​
     *  nums[i]<k。由于当 \mathrm{left}left 增加时，这个乘积是单调不增的，因此我们可以使用双指针的方法，单调地移动 \mathrm{left}left。
     *
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int  ans = 0;
        int  len = nums.length;
        int  curr = 1;
        int left = 0;
        for (int i = 0; i < len; i++) {
            curr *= nums[i];
            while ( curr >= k)  {
                curr /= nums[left++];
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
