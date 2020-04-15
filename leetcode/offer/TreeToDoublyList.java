/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/14
 * Time: 3:31 PM
 */
public class TreeToDoublyList {
    class Node {
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

    public Node treeToDoublyList(Node root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left != null) {
            Node tmp = treeToDoublyList(root.left);
            tmp.right = root;
            root.left = tmp;
        }
        if (root.right != null) {
            Node tmp = treeToDoublyList(root.left);
            tmp.left = root;
            root.right = tmp;
        }
        return root;
    }
}
