package zijie;

import java.util.Arrays;
import java.util.HashMap;

public class FindRelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        int[] nums2 = Arrays.copyOf(nums, len);
        Arrays.sort(nums2);
        HashMap<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < len; i++) {
            rank.put(nums2[i], len - i);
        }
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            int rankIndex = rank.get(nums[i]);
            if (rankIndex == 1) {
                ans[i] = "Gold Medal";
            } else if (rankIndex == 2) {
                ans[i] = "Silver Medal";
            } else if (rankIndex == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = String.valueOf(rankIndex);
            }
        }
        return ans;
    }
}
