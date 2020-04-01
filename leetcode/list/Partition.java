package list;

public class Partition {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(4);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(5);
        ListNode root4 = new ListNode(2);
        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        System.out.println((new Partition()).partition(root, 3));
    }
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode left = new ListNode(0);
        ListNode leftEnd = left;
        ListNode right = new ListNode(0);
        ListNode rightEnd = right;
        while (head != null) {
            if (head.val < x) {
                leftEnd.next = new ListNode(head.val);
                leftEnd = leftEnd.next;
            } else {
                rightEnd.next = new ListNode(head.val);
                rightEnd = rightEnd.next;
            }
            head = head.next;
        }
        leftEnd.next = right.next;
        return left.next;
    }
}
