package array;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(solution(nums));
    }
    private static int solution(int[] nums) {
        int len = nums.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
