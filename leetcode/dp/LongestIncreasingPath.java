package dp;

public class LongestIncreasingPath {

    public static void main(String[] args) {
//        int[][] matrix = new int[][]{
//                {9,9,4},
//                {6,6,8},
//                {2,1,1}
//        } ;
//        int[][] matrix = new int[][]{
//                {7,1,5},
//                {2,4,7},
//                {8,2,0}};
        int[][] matrix = new int[][]{
                {43,12,68,70,83,27,87,25},
                {26,10,33,3,97,66,97,21},
                {84,93,85,64,41,74,1,50},
                {79,75,53,44,49,86,57,49},
                {25,6,47,77,73,78,90,1},
                {9,36,5,62,94,52,63,81},
                {83,44,39,85,35,56,53,61},
                {32,47,80,73,92,20,94,0},
                {5,35,93,33,83,52,76,38},
                {2,67,79,31,28,71,56,0}};

        System.out.println((new LongestIncreasingPath()).longestIncreasingPath(matrix));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                max = Math.max(bfs(matrix, i, j, -1), max);

            }
        }
        return  max;
    }

    public int bfs(int[][] matrix, int row, int col, int pre) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row >= rows || row < 0 || col >= cols || col < 0 || matrix[row][col] <= pre || matrix[row][col] == '/') {
            return 0;
        }
        int max = 0;
        int tmp = matrix[row][col];
        matrix[row][col] = '/';
        int lenght = Math.max(Math.max(bfs(matrix, row - 1, col, tmp), bfs(matrix, row + 1, col, tmp))
                , Math.max(bfs(matrix, row, col + 1, tmp), bfs(matrix, row, col - 1, tmp))) + 1;
        max = Math.max(lenght, max);
        matrix[row][col] = tmp;


        return max;
    }

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int maxIndex = 0;
        int left =  0;
        int right = len - 1;
        while (left <= right) {
            if (nums[right] > nums[maxIndex]) {
                maxIndex = right;
            }
            if (nums[left] > nums[maxIndex]) {
                maxIndex = left;
            }
            left++;
            right--;
        }

        return maxIndex;
    }
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
