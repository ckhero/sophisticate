package list;

/**
 * 148. 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
 * 示例 1:
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class SortList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(1);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(6);
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
//        root3.next = root4;
        System.out.println((new SortList()).sortList(root));
    }
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(next);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode end = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                end.next = new ListNode(left.val);
                left = left.next;
            } else {
                end.next = new ListNode(right.val);
                right = right.next;
            }
            end = end.next;
        }
        while (left != null) {
            end.next = new ListNode(left.val);
            left = left.next;
            end = end.next;
        }

        while (right != null) {
            end.next = new ListNode(right.val);
            right = right.next;
            end = end.next;
        }
        return dummy.next;
    }
}
