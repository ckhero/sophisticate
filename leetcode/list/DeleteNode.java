package list;

public class DeleteNode {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        deleteNode(n2);
    }

    private static void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next;
    }
}
