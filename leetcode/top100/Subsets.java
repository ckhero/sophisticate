import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/3
 * Time: 5:33 PM
 */
/*
78. 子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = (new Subsets()).subsets(nums);
        System.out.println();
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        ans.add(new ArrayList<>());
        backtrack(nums, path, ans, 0);
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> path, List<List<Integer>> ans, int start) {
        if (path.size() == nums.length || start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backtrack(nums, path, ans, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
