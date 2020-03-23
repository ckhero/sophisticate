package offer;

import java.util.*;

public class LongestPalindrome {
    public static void main(String[] args) {
//        System.out.println((new LongestPalindrome()).longestPalindromeSubseq("bbbab"));
        System.out.println((new LongestPalindrome()).reverseWords("a good   example"));
    }


    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        int[][] dp = new int[len][len];
        for (int i = len - 2; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }


    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            ans += count[i] / 2  * 2;
            if (count[i] % 2 == 1 && ans % 2 ==0) {
                ans++;
            }
        }
        return ans;
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = strs.length - 1; i >= 0  ; i--) {
            if (strs[i].equals("")) continue;
            ans.append(strs[i]);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode>  queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(tmp);
        }
        return ans;
    }
}
