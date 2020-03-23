package array;

import java.util.Arrays;
import java.util.HashMap;

public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};
        int[] res = intersect(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    private static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int i = 0; i < len1; i++) {
            count.put(nums1[i], count.getOrDefault(nums1[i], 0) + 1);
        }
        int index = 0;
        for (int j = 0; j < len2; j++) {
            int tmp = nums2[j];
            if (count.getOrDefault(tmp, 0) > 0) {
                nums1[index++] = tmp;
                count.put(tmp, count.get(tmp) - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}
