package list;

public class ReorderList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);
//        root.next = root1;
//        root1.next = root2;
//        root2.next = root3;
        (new ReorderList()).reorderList(root);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);

    }

    public void reorderList(ListNode head) {
        if (head == null ) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = reverse(slow.next);
        slow.next = null;
        ListNode left=  dummy.next;
        ListNode end = head;
        while (left != null && right != null) {
            if (end == head) {
                ListNode next = left.next;
                head.val = left.val;
                end.next = new ListNode(right.val);
                end = end.next;
                left = next;
            } else {
                end.next = new ListNode(left.val);
                end.next.next = new ListNode(right.val);
                end = end.next.next;
                left = left.next;

            }
            right = right.next;

        }
        if (right != null && end != head) end.next = right;
        if (left != null && end != head) end.next = left;
    }

    public ListNode reverse(ListNode root) {
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
