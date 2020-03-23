package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class ShuffleArr {
    int[] originalArr;
    Random rand = new Random();

    public ShuffleArr(int[] nums) {
        originalArr = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = Arrays.copyOf(originalArr, originalArr.length);
        for (int i = 0; i < arr.length; i++) {
            int nextKey = rand.nextInt(arr.length - i) + i;
            int tmp = arr[nextKey];
            arr[nextKey] = arr[i];
            arr[i] = tmp;
        }
        return arr;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] ans = new int[len1 > len2 ? len2 : len1];

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            count.put(nums1[i], 1);
        }
        int index = 0;
        for (int i = 0; i < len2; i++) {
            if (count.containsKey(nums2[i]) && count.get(nums2[i]) > 0) {
                count.remove(nums2[i]);
                ans[index++] = nums2[i];
            }
        }
        return Arrays.copyOfRange(ans, 0, index - 1);
    }
}
