/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/10
 * Time: 6:13 PM
 */

import java.util.*;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * 76. 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 通过次数32,862提交次数92,240
 * 在真实的面试中遇到过这道题？
 *
 * 是
 *
 * 否
 */
public class MinWindow {
    public static void main(String[] args) {
        (new MinWindow()).lengthOfLongestSubstring("abcabcbb");
        System.out.println((new MinWindow()).minWindow("ADOBECODEBANC", "ABC"));
        System.out.println();
    }
    public String minWindow(String s, String t) {
        if (s.isEmpty() || t.length() > s.length()) {
            return "";
        }
        int len = s.length();
        int[] needs = new int[128];
        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)] += 1;
        }
        int[] windows = new int[128];
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int match = 0;

        while (right < len) {
            int curr = s.charAt(right);
            //如果是需要的 做如下处理
            windows[curr] += 1;
            // 如果是需要的字符串并且 需要的字符数量小于窗口中的数量的时候
            if (needs[curr] > 0 && needs[curr] >= windows[curr]) {
                match++;
            }
            //满足最小串 开始缩小
            while (match == t.length()) {
                int currLeft = s.charAt(left);
                if (needs[currLeft] > 0 && needs[currLeft] >= windows[currLeft]) {
                    match--;
                }
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }
                windows[currLeft]--;
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "": s.substring(start, start + minLen);
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int curr = nums[left] + nums[right];
            if (curr == target) {
                return new int[]{nums[left], nums[right]};
            }
            if (curr > target) {
                right--;
            }
            if (curr < target) {
                left++;
            }
        }
        return new int[]{};
    }

    /**
     * https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int len = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        while (right < len) {
            char curr = s.charAt(right);
            if (count.containsKey(curr)) {
                left = Math.max(left, count.get(curr) + 1);
            }
            maxLen = Math.max(right - left + 1, maxLen);
            count.put(curr, right);
            right++;
        }
        return maxLen;

    }
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    /**
     * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        while (head != null) {
            idx++;
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[idx];
        idx = 0;
        while (!stack.isEmpty()) {
            ans[idx++] = stack.pop();
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/add-two-numbers-ii/
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode pre = null;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;

            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;

            ListNode curr = new ListNode(sum % 10);
            curr.next = pre;
            pre = curr;
        }
        if (carry > 0) {
            ListNode curr = new ListNode(carry);
            curr.next = pre;
            pre = curr;
        }
        return pre;
    }

    private ListNode reverse(ListNode root) {
        ListNode pre = null;

        while (root != null) {
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
