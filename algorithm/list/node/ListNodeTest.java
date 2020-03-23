package list.node;

/**
 * https://www.cnblogs.com/kubidemanong/p/11334017.html
 */
public class ListNodeTest {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head2.setNext(head3);
        head1.setNext(head2);
        head.setNext(head1);
//        System.out.println(head.toString());
//        System.out.println(getDecimalValue(head));
      ListNode pres = reverseKGroup(head, 3);
        for(int i = 0;i < 4;i++){
             System.out.println(pres.val);
            pres = pres.next;
        }
    }

    private static ListNode reverseKGroup(ListNode list, int k) {
        ListNode res = null;
        ListNode tmp = list;
        for (int i = 0; i < k - 1; i++) {
            if (tmp == null) {
                break;
            }
            tmp = tmp.next;
        }
        if (tmp == null) {
            return list;
        }
        ListNode l2 = tmp.next;
        tmp.next = null;
        ListNode newList = reverseList(list);
        ListNode newTmp = reverseKGroup(l2, k);
        list.next = newTmp;
        return newList;
    }

    private static ListNode reverseList(ListNode head) {
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

    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }
}
