package sort;

import java.util.Arrays;

public class MinNumber {
    public static void main(String[] args) {
        int[] arr = {999999998,999999997,999999999};
        String aa = (new MinNumber()).minNumber(arr);
        System.out.println(" --结果 :" + Arrays.toString(arr));
        System.out.println(aa);
    }
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            str.append(nums[i]);
        }
        return str.toString();
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return ;
        }
        int key = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (compare(nums[j], key) && i < j) {
                j--;
            }

            while (compare(key, nums[i]) && i < j) {
                i++;
            }

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = key;
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public boolean compare(long a, long b) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        str1.append(a);
        str1.append(b);
        str2.append(b);
        str2.append(a);
        return Long.parseLong(str1.toString()) >= Long.parseLong(str2.toString());
//        if (a == 0 && b !=0) {
//            return true;
//        }
//        if (a != 0 && b ==0) {
//            return false;
//        }
//        while (a / 10 != 0) {
//            a /= 10;
//        }
//        while (b / 10 != 0) {
//            b /= 10;
//        }
//        int atmp = a % 10;
//        int btmp = b % 10;
//        if (atmp >= btmp) {
//            return true;
//        }
//        return  false;
    }
}
