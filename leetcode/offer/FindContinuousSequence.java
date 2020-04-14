package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 面试题57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 */
public class FindContinuousSequence {
    public static void main(String[] args) {
        int ans = (new FindContinuousSequence()).strStr("hello", "lle");
        System.out.println(ans);
    }
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int sum = 0;
        int left = 1;
        int right = 1;
        while (right <= target / 2 + 2) {

            if (sum < target) {
                sum += right;
                right++;
                continue;
            }
            if (sum > target) {
                sum -= left;
                left++;
                continue;
            }
            if (sum == target) {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                ans.add(arr);
                sum -= left;
                left++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        if (haystack.isEmpty()) {
            return -1;
        }
        int[] next = next(needle);
        int k = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (k > 0 && haystack.charAt(i) != needle.charAt(k)) {
                k = next[k - 1];
            }
            if (haystack.charAt(i) == needle.charAt(k)) {
                k++;
            }

            if (k == needle.length()) {
                return i - k + 1;
            }
        }
        return -1;
    }

    public int[] next(String needle) {
        int len = needle.length();
        int k = 0;
        int[] next = new int[len];
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            while (k > 0 && needle.charAt(i) != needle.charAt(k)) {
                k = next[k - 1];
            }
            if (needle.charAt(i) == needle.charAt(k)) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
