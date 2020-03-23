package offer;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new MissingNumber()).sortArrayByParityII(new int[]{2,3})));
    }
    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0] == 0 ? 1 :0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left++] != nums[left] - 1) {
                return nums[left] - 1;
            }
            if (nums[right--] != nums[right] + 1) {
                return nums[right] + 1;
            }
        }
        return nums[0] == 0 ? nums[nums.length - 1] + 1 : 0;
    }

    public int[] sortArrayByParityII(int[] A) {
        int event = 0;
        int odd = 1;

        while (odd < A.length && event < A.length) {
            while (odd < A.length && A[odd] % 2 == 1) {
                odd +=2;
            }
            while (event < A.length && A[event] % 2 == 0) {
                event +=2;
            }
            if (odd < A.length && event < A.length) {
                int tmp = A[odd];
                A[odd] = A[event];
                A[event] = tmp;
                odd +=2;
                event +=2;
            }
        }
        return A;
    }
}
