package offer;

public class CopyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copy(head);
        radomDirect(head);
        return reList(head);
    }

    public void copy(Node head) {
        while (head != null) {
            Node cloneNode = new Node(head.val);
            Node nextNode = head.next;
            head.next = cloneNode;
            cloneNode.next = nextNode;
            head = cloneNode.next;
        }
    }

    public void radomDirect(Node head) {
        while (head != null) {
            Node cloneNode = head.next;

            if (head.random != null) {
                Node direct = head.random;
                cloneNode.random = direct.next;
            }
            head = cloneNode.next;
        }
    }
    public Node reList(Node head) {
        Node cloneNode = head.next;
        Node cloneHead = cloneNode;
        head.next = cloneNode.next;
        head = head.next;
        while (head != null) {
            cloneNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cloneNode = cloneNode.next;
        }
        return cloneHead;
    }

//    Node cloneNode = head.next;
//    Node cloneHead = cloneNode;
//    head.next = cloneNode.next;
//    head = head.next;
//        while(head!=null){
//        cloneNode.next = head.next;
//        head.next = head.next.next;
//        head = head.next;
//        cloneNode = cloneNode.next;
//    }
//        return cloneHead;
}
