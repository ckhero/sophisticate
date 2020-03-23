package list;

public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);

        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        System.out.println(addTwoNumbers(n3, n6));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode res2 = res;
        int carry = 0;
        ListNode currNode = null;

        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            if (sum >= 10) {
                carry = 1;
                currNode = new ListNode(sum - 10);
            } else {
                carry = 0;
                currNode = new ListNode(sum);
            }
            res2.next = currNode;
            res2 = res2.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            res2.next = new ListNode(carry);
        }
        return res.next;
    }
}
