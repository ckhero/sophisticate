package offer;

public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        queue.push_back(3);
        queue.push_back(4);

        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
        System.out.println(queue.pop_front());
    }
    public static class ListNode {
        int val;
        int max;
        ListNode pre;
        ListNode next;
        ListNode(int x, int max) { val = x; this.max = max;}
    }
    ListNode head = null;
    ListNode end = null;

    public MaxQueue() {
        head = new ListNode(-1, -1);
        end = new ListNode(-1, -1);
        head.next = end;
        end.pre = head;
    }

    public int max_value() {
        return head.next.max;
    }

    public void push_back(int value) {
        ListNode node = new ListNode(value, Math.max(value, max_value()));
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public int pop_front() {
        int ans = -1;
        if (end.pre != head) {
            ans = end.pre.val;
            end.pre = end.pre.pre;
            end.pre.next = end;
        }
        return ans;
    }
}
