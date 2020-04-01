package list;

public class DeleteDuplicatesMid {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);

        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        System.out.println((new DeleteDuplicatesMid()).deleteDuplicates(n1));
    }
    public ListNode deleteDuplicates(ListNode head) {
        //需要一个哑结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = dummy;
        //继续被消除的 的值
        Integer pre = null;
        while (end.next != null) {
            if (pre == null) {
                //值为空的时候 判断下一个节点和下下一个节点
                if (end.next.next != null && end.next.val == end.next.next.val) {
                    pre = end.next.val;
                    end.next = end.next.next.next;
                    continue;
                }  else {
                    end = end.next;
                }
            } else {
                //如果pre和下面的不相等，说明下一个节点 不一定要消除。是否消除看他和他的下下个节点的关系
                if (pre != end.next.val) {
                    pre = null;
                    continue;
                } else {
                    //相等直接消除
                    end.next = end.next.next;
                    continue;
                }
            }
        }
        return dummy.next;
    }
}
