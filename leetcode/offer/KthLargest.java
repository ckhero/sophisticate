import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/14
 * Time: 11:57 AM
 */
public class KthLargest {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (minHeap.size() < k) {
                    minHeap.add(curr.val);
                } else {
                    if (minHeap.peek() < curr.val) {
                        minHeap.poll();
                        minHeap.add(curr.val);
                    }
                }
            }
        }
        return minHeap.poll();
    }
}
