package list;

public class SplitListToParts {
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
        System.out.println((new SplitListToParts()).splitListToParts(root , 2));
    }
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return null;
        }
        int len = getLen(root);
        int sepLen = len / k;
        ListNode[] ans = new ListNode[k];
        int carry = len % k;
        for (int i = 0; i < k; i++) {
            int currLen = sepLen;
            if (carry > 0) {
                currLen += 1;
                carry--;
            }
            ListNode dummy = new ListNode(0);
            ListNode end = dummy;
            while (currLen > 0 && root != null) {
                currLen--;
                end.next = new ListNode(root.val);
                end = end.next;
                root = root.next;
            }
            ans[i] = dummy.next;
        }
        return ans;
    }

    public int getLen(ListNode root) {
        ListNode tmp = root;
        int index = 0;
        while (tmp != null) {
            index++;
            tmp = tmp.next;
        }
        return index;
    }
}
