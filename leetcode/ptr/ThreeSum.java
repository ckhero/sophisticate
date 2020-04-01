package ptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
//        System.out.println((new ThreeSum()).threeSum(new int[]{-1, -1,0, 0, 0}));
        System.out.println((new ThreeSum()).threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            int curr = nums[i];
            if (i > 0 && curr == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                int sum = curr + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> tmp = Arrays.asList(curr,  nums[left++], nums[right--]);
                    ans.add(tmp);
                    continue;
                }
                if (sum < 0) {
                    while (left < right && nums[left] == nums[++left]) {}
                } else if (sum > 0) {
                    while (left < right && nums[right] == nums[--right]) {}
                }
            }
        }
        return ans;
    }
}
