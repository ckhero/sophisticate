package offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MajorityElement {
    public static void main(String[] args) {

        System.out.println((new MajorityElement()).majorityElement(new int[]{1,2,2,3,2,1,1,3}));
    }
    /**
     * 1、如果投A（当前元素等于A），则A的票数++;
     * 2、如果投B（当前元素等于B），B的票数++；
     * 3、如果A,B都不投（即当前与A，B都不相等）,那么检查此时A或B的票数是否减为0，如果为0,则当前元素成为新的候选人；如果A,B两个人的票数都不为0，那么A,B两个候选人的票数均减一。
     *
     * 作者：jerry_nju
     * 链接：https://leetcode-cn.com/problems/majority-element-ii/solution/169ti-sheng-ji-ban-xiang-jie-zhu-xing-jie-shi-tong/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0,cand2 = 0,count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if  (cand1 == curr) {
                count1 ++;
                continue;
            }
            if  ( cand2 == curr) {
                count2 ++;
                continue;
            }

            if  (count1 == 0) {
                cand1 = curr;
                count1 ++;
                continue;
            }
            if  (count2 == 0) {
                cand2 = curr;
                count2 ++;
                continue;
            }
            count1--;
            count2--;
        }

        //确定是否 真的存在
        count1 = 0; count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cand1 == nums[i]) {
                count1++;
                continue;
            }
            if (cand2 == nums[i]) {
                count2++;
                continue;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (count1 > nums.length/3) {
            ans.add(cand1);
        }
        if (count2 > nums.length/3) {
            ans.add(cand2);
        }
        return ans;
    }

    /**
     * 169. 多数元素
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     *
     * 投票法
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer ans = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                ans = nums[i];
            }
            count += (ans == nums[i]) ? 1 : -1;

        }
        return ans;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols;

        while (row < rows && col >= 0) {
            int curr = matrix[row][col];
            if (curr == target) {
                return true;
            }
            if (curr < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
