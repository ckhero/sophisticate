package list;

public class MergeKLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        while (len > 1) {
            int i;
            for (i = 0; i < len / 2; i++) {
                lists[i] = mergeKLists(lists[i * 2], lists[i * 2 + 1]);
            }
            if (len % 2 == 1) {
                lists[i] = lists[len - 1];
                len += 1;
            }
            len /= 2;
        }
        return lists[0];
    }

    public ListNode mergeKLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode ansTmp = ans;
        while (l1 != null && l2 != null) {
            int currVal;
            if (l1.val <= l2.val) {
                currVal = l1.val;
                l1 = l1.next;
            } else {
                currVal = l2.val;
                l2 = l2.next;
            }
            ansTmp.next = new ListNode(currVal);
            ansTmp = ansTmp.next;
        }
        if (l1 != null) {
            ansTmp.next = l1;
        }

        if (l2 != null) {
            ansTmp.next = l2;
        }
        return ans.next;
    }
}
