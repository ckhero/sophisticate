package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new MergeSort()).sort(new int[]{1,2,5,4,3}, 0, 5 -1)));
    }

    public int[] sort(int[] nums, int low, int hight) {
        int mid = (low  + hight) / 2;
        if (low < hight) {
            sort(nums, low, mid);
            sort(nums, mid + 1, hight);
            merge(nums, low, mid, hight);
        }
        return nums;
    }

    public void merge(int[] nums, int low, int  mid, int high) {
        int[] tmp = new int[high - low + 1];
        int idx = 0;
        int i = low;
        int j = mid + 1;
        while (i  <= mid && j <= high) {
            tmp[idx++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[idx++] = nums[i++];
        }

        while (j <= high) {
            tmp[idx++] = nums[j++];
        }

        for (int k = 0; k < tmp.length; k++) {
            nums[low + k] = tmp[k];
        }
    }
}
