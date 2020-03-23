import java.util.Arrays;

public class Merge88 {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,0,0,0};
        int[] arr2 = {2,5,6};
        merge(arr1, arr1.length - arr2.length, arr2, arr2.length);
       System.out.println(Arrays.toString(arr1));
    }
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_c = new int[m];
        System.arraycopy(nums1, 0, nums1_c, 0, m);
        int p1 = 0, p2 = 0, index = 0;
        while (p1 < m && p2 < n) {
            nums1[index++] = nums1_c[p1] < nums2[p2] ? nums1_c[p1++] : nums2[p2++];
        }

        if (p1 < m) {
            System.arraycopy(nums1_c, p1, nums1, p1 + n, m - p1);
        }

        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p2 + m, n - p2);
        }
    }
}
