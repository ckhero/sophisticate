import javax.swing.*;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 *
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("helloa");
        System.out.println(trie.search("hell"));
        System.out.println(trie.search("helloa"));
    }
    TrieNode root;
    Character end = '1';
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        int idx = 0;
        TrieNode currNode = root;
        while (currNode.getChild() != null && idx < word.length()) {
            TrieNode childNode = currNode.getChild().get(word.charAt(idx));
            if (childNode != null) {
                idx++;
                currNode = childNode;
            } else {
                break;
            }
        }
        while (idx < word.length()) {
            Character curr = word.charAt(idx++);
            TrieNode childNode = new TrieNode();
            childNode.setVal(curr);
            currNode.getChild().put(curr, childNode);
            currNode = childNode;
        }
        //标记技术
        currNode.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int idx = 0;
        TrieNode currNode = root;
        while (currNode.getChild() != null && idx < word.length()) {
            TrieNode childNode = currNode.getChild().get(word.charAt(idx));
            if (childNode != null) {
                idx++;
                currNode = childNode;
            } else {
                break;
            }
        }
        return currNode.isEnd && idx == word.length();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int idx = 0;
        TrieNode currNode = root;
        while (currNode.getChild() != null && idx < prefix.length()) {
            TrieNode childNode = currNode.getChild().get(prefix.charAt(idx));
            if (childNode != null) {
                idx++;
                currNode = childNode;
            } else {
                break;
            }
        }
        return idx == prefix.length();
    }

    private class TrieNode {
        Character val;
        HashMap<Character, TrieNode> child = new HashMap<>();
        boolean isEnd;
        public Character getVal() {
            return val;
        }

        public void setVal(Character val) {
            this.val = val;
        }

        public HashMap<Character, TrieNode> getChild() {
            return child;
        }

        public void setChild(HashMap<Character, TrieNode> child) {
            this.child = child;
        }

        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }
}
