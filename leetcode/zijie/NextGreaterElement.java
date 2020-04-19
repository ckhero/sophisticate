package zijie;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/next-greater-element-iii/
 * 556. 下一个更大元素 III
 * 给定一个32位正整数 n，你需要找到最小的32位整数，其与 n 中存在的位数完全相同，并且其值大于n。如果不存在这样的32位整数，则返回-1。
 *
 * 示例 1:
 *
 * 输入: 12
 * 输出: 21
 * 示例 2:
 *
 * 输入: 21
 * 输出: -1
 */
public class NextGreaterElement {
    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE);
        (new NextGreaterElement()).nextGreaterElement(1999999999);
    }
    public int nextGreaterElement(int n) {
        char[] nums = String.valueOf(n).toCharArray();
        int pos = Integer.MIN_VALUE;
        int posEnd = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (j > pos) {
                        pos = j;
                        posEnd = i;
                    }
                    break;
                }
            }
        }
        if (pos == Integer.MIN_VALUE) {
            return -1;
        }
        char tmp = nums[pos];
        nums[pos] = nums[posEnd];
        nums[posEnd] = tmp;
        if (nums.length == 10 && nums[0] > 2) {
            return -1;
        }
        Arrays.sort(nums, pos + 1, nums.length);
        return Integer.parseInt(String.valueOf(nums));
    }
}
