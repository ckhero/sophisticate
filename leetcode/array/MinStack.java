package array;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
       System.out.println( minStack.getMin());
        minStack.pop();
       System.out.println( minStack.top());
        System.out.println(minStack.getMin());
    }
    class Node{
        int val;
        int min;
        Node next;
        public Node(int x, int min, Node next) {
            this.val = x;
            this.min = min;
            this.next = next;

        }
    }
    Node head = null;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        head= new Node(x, Math.min(getMin(), x), head);
    }

    public void pop() {
        if (head != null) {
             head = head.next;
        }
    }

    public int top() {
        return head == null ? null : head.val;
    }

    public int getMin() {
        return head == null ? Integer.MAX_VALUE : head.min;
    }
}
