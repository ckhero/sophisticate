package array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] res = twoSum(nums, 9);
        System.out.println(Arrays.toString(res));

    }

    private static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            int left = target - nums[i];
//            for (int j = i + 1; j < nums.length; j++) {
//                if (left == nums[j]) {
//                    res[0] = i;
//                    res[1] = j;
//                    break;
//                }
//            }
//        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left) && map.get(left) != i ){
                return new int[] {i, map.get(left)};
            }
        }
        return res;
    }
}
