package offer;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 面试题61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count0 = 0;
        int gap = 0;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
                continue;
            }
            if (pre >= 0) {
                int tmp = nums[i] - nums[pre] - 1;
                if (tmp < 0) {
                    return false;
                }
                if ( tmp > 0) {
                    gap += tmp;
                }
            }
            pre = i;
        }
        return gap == 0 || count0 >= gap;
    }
}
