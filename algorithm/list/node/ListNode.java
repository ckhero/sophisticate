package list.node;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
