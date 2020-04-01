package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * 通过次数46,826提交次数73,132
 */
public class MinimumTotal {
    public static void main(String[] args) {
        List<List<Integer>> aa = new ArrayList<>();
        List<Integer> aa1 = new ArrayList<>();
        aa1.add(2);
        List<Integer> aa2 = new ArrayList<>();
        aa2.add(3);
        aa2.add(4);

        List<Integer> aa3 = new ArrayList<>();
        aa3.add(6);
        aa3.add(5);
        aa3.add(7);
        List<Integer> aa4 = new ArrayList<>();
        aa4.add(4);
        aa4.add(1);
        aa4.add(8);
        aa4.add(3);
        aa.add(aa1);
        aa.add(aa2);
        aa.add(aa3);
        aa.add(aa4);
        System.out.println((new MinimumTotal()).minimumTotal(aa));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int high = triangle.size();
        if (high == 0) {
            return 0;
        }
        if (high == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[high];
        dp[0] = triangle.get(1).get(0) + triangle.get(0).get(0);
        dp[1] = triangle.get(1).get(1) + triangle.get(0).get(0);
        for (int i = 2; i < high; i++) {
            int len = triangle.get(i).size();
            int pre = dp[0];
            dp[0] = triangle.get(i).get(0) + pre;
            //首位赋值 特例
            dp[len -1] = triangle.get(i).get(len - 1) + dp[len - 2];
            for (int j = 1; j < len - 1; j++) {
                int tmp = dp[i];
                dp[j] = Math.min(dp[j], pre) + triangle.get(i).get(j);
                pre = tmp;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < high; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }

    /**
     * 执行用时 :
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 79.95%
     * 的用户
     * 内存消耗 :
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 5.06%
     * 的用户
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int high = triangle.size();
        if (high == 0) {
            return 0;
        }
        if (high == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[high][high];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < high; i++) {
            int len = triangle.get(i).size();
            //首位赋值 特例
            dp[i][0] = triangle.get(i).get(0) + dp[i - 1][0];
            dp[i][len -1] = triangle.get(i).get(len - 1) + dp[i - 1][len - 2];
            for (int j = 1; j < len - 1; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < high; i++) {
            min = Math.min(dp[high - 1][i], min);
        }
        return min;
    }
}
