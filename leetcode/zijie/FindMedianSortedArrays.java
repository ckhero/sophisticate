package zijie;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 4. 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int midLeft, midRight;
        if ((l1 + l2) % 2 != 0) {
            midLeft = midRight = (l1 + l2) / 2;
        } else {
            midLeft = (l1 + l2) / 2 - 1;
            midRight = midLeft + 1;
        }
        double valLeft = 0, valRight = 0;
        int index = 0, index1 = 0, index2 = 0, tmpVal = 0;
        while (index <= midRight) {
            if (index2 >= l2) {
                tmpVal = nums1[index1++];
            } else if (index1 >= l1) {
                    tmpVal = nums2[index2++];
            } else if ( nums1[index1] <= nums2[index2]) {
                tmpVal = nums1[index1++];
            } else {
                tmpVal = nums2[index2++];
            }
            if (index == midLeft) {
                valLeft = tmpVal;
            }
            if (index == midRight) {
                valRight = tmpVal;
            }
            index++;
        }
        return (valLeft + valRight) / 2;
    }
}
