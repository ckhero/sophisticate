import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * 421. 数组中两个数的最大异或值
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
 *
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 *
 * 你能在O(n)的时间解决这个问题吗？
 *
 * 示例:
 *
 * 输入: [3, 10, 5, 25, 2, 8]
 *
 * 输出: 28
 *
 * 解释: 最大的结果是 5 ^ 25 = 28.
 */
public class FindMaximumXOR {
    public static void main(String[] args) {

        int[] nums = new int[]{1,25};
        int ans = (new FindMaximumXOR()).findMaximumXOR(nums);
        System.out.println();
    }
    public int findMaximumXOR(int[] nums) {
        TrieNode trie = new TrieNode();

        for (int num : nums) {
            TrieNode xorNode = trie;
            int currXor = 0;
            for (Character c : String.valueOf(num).toCharArray()) {
                Character toggleC = c == '1' ? '0' : '1';
                if (trie.child.containsKey(toggleC)) {
                    currXor = (currXor << 1) | 1;
                    xorNode = xorNode.child.get(toggleC);
                } else {
                    currXor = currXor << 1;
                    xorNode = xorNode.child.get(c);
                }
            }
        }
        return 1;
    }
    class TrieNode {
        HashMap<Character, TrieNode> child = new HashMap<>();
        public TrieNode() {}
    }

}
