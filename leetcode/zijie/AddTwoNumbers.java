package zijie;

import java.util.Stack;

public class AddTwoNumbers {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);

        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n7 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n7;
        n4.next = n5;
        n5.next = n6;
        System.out.println(addTwoNumbers(n1, n4));
    }
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        Integer val1, val2;
        int carry = 0;
        ListNode res = null;
        while ( !stack1.isEmpty()|| !stack2.isEmpty()) {

            val1 = !stack1.isEmpty() ? stack1.pop() : 0;
            val2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = val1 + val2 + carry;
            carry = sum >= 10 ? 1 : 0;
            ListNode tmp = new ListNode(sum % 10);
            tmp.next = res;
            res = tmp;
        }
        if (carry > 0) {
            ListNode tmp = new ListNode(carry);
            tmp.next = res;
            res = tmp;
        }
        return res;
    }
}
