package sort;

public class Merge {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, nums2.length);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0, index2 = 0, index = 0;
        int[] nums3 = new int[m];
        System.arraycopy(nums1, 0, nums3, 0, m);
        while (index1 < m && index2 < n) {
            nums1[index++] = nums3[index1] <= nums2[index2] ? nums3[index1++] : nums2[index2++];
        }

        if (index1 < m) {
            System.arraycopy(nums3, index1, nums1, index1 + n, m - index1);
        }

        if (index2 < n) {
            System.arraycopy(nums2, index2, nums1, index2 + m, n - index2);
        }
    }
}
