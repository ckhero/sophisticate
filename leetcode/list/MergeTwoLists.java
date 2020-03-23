package list;

public class MergeTwoLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
         ListNode n1 = new  ListNode(1);
         ListNode n2 = new  ListNode(2);
         ListNode n3 = new  ListNode(3);
         ListNode n4 = new  ListNode(4);
         ListNode n5 = new  ListNode(5);
        n1.next = n2;
        n3.next = n5;
        n2.next = n4;
        ListNode aa = mergeTwoLists(n2, n1);
        while (aa != null) {
            System.out.println(aa.val);
            aa = aa.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 == null ? l2 : l1;
        return res.next;
    }
}
