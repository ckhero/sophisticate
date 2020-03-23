package offer;

public class ReversePrint {
    
      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args) {

    }
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        int index = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            index++;
        }
        int[] ans = new int[index];
        index = 0;
        while (pre != null) {
            ans[index++] = pre.val;
            pre = pre.next;
        }
        return ans;
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode tmp = head;
        ListNode pre = head;
        while (tmp != null) {
            if (tmp.val == val) {
               if (pre == head) {
                   tmp = tmp.next;
               } else {
                   pre.next = tmp.next;
               }
               break;
            } else {
                pre = tmp;
                tmp = tmp.next;
            }
        }
        return head;
    }

    /**
     * 22. 链表中倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head, curr = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        while (pre != null) {
            pre = pre.next;
            curr = curr.next;
        }
        return curr;
    }

    /**
     * 两个链表的第一个公共节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next;
            node2 = node2 == null ? headA : node2.next;
        }
        return node1;
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode  dummy = new ListNode(0);
        ListNode  tmp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return dummy.next;
    }
}
