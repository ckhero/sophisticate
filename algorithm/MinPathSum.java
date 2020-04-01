import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/3/16
 * Time: 2:13 PM
 */
public class MinPathSum {
    public static void main(String[] args) throws Exception {
        int[] nums = new int[]{2147483647,-2147483647};
        List<Integer> aa = new ArrayList<>();
        aa.add(0, 1);
        aa.add(0, 2);
        System.out.println(aa.toArray());
//        System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2147483647));
    }

    private static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    private static int minDistance(String word1, String word2) {
        int rows = word1.length();
        int cols = word2.length();
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i <= rows; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }

        for (int i = 1; i <= cols; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= rows ; i++) {
            for (int j = 1; j <= cols ; j++) {
                //当前字符相等
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //交换  删除 插入
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]),  dp[i-1][j]) + 1;
                }

            }
        }
        return dp[rows][cols];
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> count = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.contains(nums[i]) ) {
                return true;
            } else {
                count.add(nums[i]);
            }
        }
        return false;
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }
        if (len == 2) {
            System.out.println(nums[0] - nums[1]);
            if (nums[0] - nums[1] <= Integer.MIN_VALUE) {
                return false;
            }
            System.out.println(Math.abs(nums[0] - nums[1]));
                return Math.abs((long)(nums[0] - nums[1])) <= t && 1 <= k;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j <= Math.min(i + k, len - 1); j++) {
                if (Math.abs(nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return helper(graph, 0);
    }

    public List<List<Integer>> helper(int[][] graph, int node) {
        int len = graph.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (node == len - 1) {
            List<Integer> path = new ArrayList<>();
            path.add(node);
            ans.add(path);
            return ans;
        }
        for (int i = 0; i < graph[node].length; i++) {
            List<List<Integer>> ansTmp = helper(graph,  graph[node][i]);
            for (List<Integer> list : ansTmp) {
                list.add(0, node);
                ans.add(list);
            }
        }
        return ans;
    }
}
