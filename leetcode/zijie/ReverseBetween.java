package zijie;

public class ReverseBetween {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 0;
        ListNode pre = null;
        while (head != null) {
            if (index >= m - 1 && index < n) {
                ListNode next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
        }
        return pre;
    }
}
