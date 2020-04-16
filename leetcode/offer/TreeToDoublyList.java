import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/14
 * Time: 3:31 PM
 */
public class TreeToDoublyList {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
//    Node head = new Node(-1);
//    Node end = head;

    public static void main(String[] args) {

        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root3 = new Node(3);
        Node root2 = new Node(2);
        Node root1 = new Node(1);
        root4.left=root2;
        root4.right = root5;
        root2.left = root1;
        root2.right = root3;
        (new TreeToDoublyList()).treeToDoublyList(root4);
        System.out.println();
    }
    public Node treeToDoublyList(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node head = null;
        Node end = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
            Node tmp = stack.pop();
            if (head == null) {
                head = tmp;
                end = head;
            } else {
                end.right = tmp;
                tmp.left = end;
                end = end.right;
            }
            curr = tmp.right;
        }
        if (head != null) {
            end.right = head;
            head.left = end;
        }
        return head;
    }
}
