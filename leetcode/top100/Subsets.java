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
        System.out.println();
    }

//    public List<List<Integer>> subsets(int[] nums) {
//
//    }
//
//    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i]) continue;
//            path.add(nums[i]);
//            backtrack(used);
//        }
//    }
}
