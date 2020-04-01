package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1048. 最长字符串链
 * 给出一个单词列表，其中每个单词都由小写英文字母组成。
 *
 * 如果我们可以在 word1 的任何地方添加一个字母使其变成 word2，那么我们认为 word1 是 word2 的前身。例如，"abc" 是 "abac" 的前身。
 *
 * 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word_1 是 word_2 的前身，word_2 是 word_3 的前身，依此类推。
 *
 * 从给定单词列表 words 中选择单词组成词链，返回词链的最长可能长度。
 *
 *
 * 示例：
 *
 * 输入：["a","b","ba","bca","bda","bdca"]
 * 输出：4
 * 解释：最长单词链之一为 "a","ba","bda","bdca"。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] 仅由小写英文字母组成。
 *
 *
 * 通过次数3,092提交次数7,669
 */
public class LongestStrChain {
    public static void main(String[] args) {
//        String[] words = new String[]{"a","b","ba","bca","bda","bdca"};
        //String[] words = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx",
          //      "zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        String[] words = new String[]{"bqtmbnugq","bjqtmbnuwsgq","m","btmnugq","czlhk",
                "ihkgszexnh","wiszechhcxldcrow","kgszn","lhk","zlzfgmjurcntwvn","jjvodlrsmdmie","tm",
                "ihqkgpszexnh","wnwpxg","zmun","hkgszenh","zmucnwn","kgzn","yjmk","wiszechcxldcrow","fnnh","yjm","jjvodlrmdmie","bqtmnugq","hkgszen","wehcxdrow","nhed","zmucn","wisehcxdrow","fnnlh","wehcxdro","zlzgmjurcntwvn","wnwg","jjvodlmde","wisechcxldcrow","wiehcxdrow","nhxyeedlcqxw","wehcxr","zzgmjurcnwvn","btmgq","nwdhslknbwpxg","ihqkgszexnh","jjvodlrsmdmhie","jjvodlmd","wdhslknbwpxg","nhedxw","wisehcxldcrow","btmugq","mfnnlfh","bqtmbnuwgq","nhedcxw","bqtmbnuwsgq","nhe","zzgmjurcntwvn","jjvodlrmdie","whslknwpxg","wdhslknwpxg","wsnwpxg","jjvodlm","hkgszexnh","zzgmjucnwvn","nhxyeedlcxw","nhxedcxw","zzmucnwn","hkgszn","zmucnw","whsnwpxg","czlmhk","whsknwpxg","wehcxro","wnwpg","nhxeedcxw","nwdhslknbjwpxg","nhedw","tmg","zlhk",
                "zlzfgmjurcntwvnr","jjvodlmdie","zzmjucnwvn","mfnnlh","zzmjucnwn","wisehcxldrow","tmgq","nhxyeedcxw"};
        System.out.println((new LongestStrChain()).longestStrChain(words));
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int len = words.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        dp[0] = 1;
        int max  = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0 ; j--) {
                if (isChild(words[j], words[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public boolean isChild(String s, String t) {
        //word1 的任何地方添加一个字母使其变成 word2
        if(t.length()!=s.length()+1)
            return false;
        int sx = 0;
        int tx = 0;
        while (sx <  s.length() && tx <  t.length()) {
            char  currS = s.charAt(sx);
            char  currT = t.charAt(tx);
            if (currS == currT) {
                sx++;
                tx++;
                continue;
            }
            tx++;
        }
        return sx == s.length();
    }
}
