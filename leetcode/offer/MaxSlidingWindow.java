package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 *https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {

        int[] aa = new int[]{1,3,1,2,0,5};
        (new MaxSlidingWindow()).maxSlidingWindow(aa, 3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        }
        int[] ans = new int[len - k + 1];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i -k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.add(i);
            if (i >= k - 1) {
                ans[idx++] = nums[deque.peekFirst()];

            }
        }
        return ans;
    }
}
