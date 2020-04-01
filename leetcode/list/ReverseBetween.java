package list;

public class ReverseBetween {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(2);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(4);
        ListNode root4 = new ListNode(5);
        root.next = root1;
        root1.next = root2;
//        root2.next = root3;
//        root3.next = root4;
        (new ReverseBetween()).reverseBetween(root, 3, 3);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (index < n) {
            // 先找到要 翻转的前置节点
            if (index < m) {
                pre = pre.next;
                index++;
                continue;
            }
            if (index < n) {
                ListNode start = pre.next;
                ListNode end = start;
                while (index < n) {
                    end = end.next;
                    index++;
                }
                ListNode next = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = next;
            }
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
