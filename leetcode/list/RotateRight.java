package list;

public class RotateRight {
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
        System.out.println((new RotateRight()).rotateRight(root , 2));
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode leftEnd = head;
        ListNode right = head;
        while (k >= 0 && right != null) {
            k--;
            right = right.next;
        }

        while (right != null) {
            leftEnd = leftEnd.next;
            right = right.next;
        }
        right = leftEnd.next;
        ListNode rightEnd = leftEnd.next;
        while (rightEnd != null && rightEnd.next != null) {
            rightEnd = rightEnd.next;
        }
        leftEnd.next = null;
        if (rightEnd != null) {
            rightEnd.next = head;
        }
        return right;

    }
}
