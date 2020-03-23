package zijie;

public class ProductExceptSelf {
    /**
     * 238. 除自身以外数组的乘积
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *
     *
     *
     * 示例:
     *
     * 输入: [1,2,3,4]
     * 输出: [24,12,8,6]
     *
     *
     * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
     *
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     *
     * 进阶：
     * @param nums
     * @return
     */

    /**
     * 概述
     * 这似乎是一个简单的问题，可以在线性时间和空间内解决。可以先计算给定数组所有元素的乘积，然后对数组中的每个元素 xx，将乘积除以 xx 来求得除自身值的以外的数组乘积。
     *
     * 然后这样的解决方法有一个问题，就是如果输入数组中出现 0，那么这个方法就失效了。而且在问题中说明了不允许使用除法运算。这增加了这个问题的难度。
     *
     * 方法一：左右乘积列表
     * 我们不必将所有数字的乘积除以给定索引处的数字得到相应的答案，而是可以利用索引处左侧的所有数字乘积和右侧所有数字的乘积相乘得到答案。
     *
     * 对于给定索引 ii，我们将使用它左边所有数字的乘积乘以右边所有数字的乘积。让我们更加具体的描述这个算法。
     *
     * 算法：
     *
     * 初始化两个空数组 L 和 R。对于给定索引 i，L[i] 代表的是 i 左侧所有数字的乘积，R[i] 代表的是 i 右侧所有数字的乘积。
     * 我们需要用两个循环来填充 L 和 R 数组的值。对于数组 L，L[0] 应该是 1，因为第一个元素的左边没有元素。对于其他元素：L[i]=L[i-1]*nums[i-1]。
     * 同理，对于数组 R，R[length-1] 应为 1。length 指的是输入数组的大小。其他元素：R[i]=R[i+1]*nums[i+1]。
     * 当 R 和 L 数组填充完成，我们只需要在输入数组上迭代，且索引 i 处的值为：L[i]*R[i]。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i-1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i+1];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
