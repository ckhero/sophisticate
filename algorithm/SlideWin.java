import java.util.Arrays;
import java.util.HashMap;

/**
 * 滑动窗口算法
 * https://www.zhihu.com/topic/20746237/intro
 * https://blog.csdn.net/happy_bigqiang/article/details/95623385
 */
public class SlideWin {
    public static void main(String[] args) throws Exception {
        int[] arr = {100, 400, 200, 300};
//        System.out.println(maxSumForce(arr, 2));
//        System.out.println(maxSumSlide(arr, 2));
//        System.out.println(minLetters("ABAACBAB", "ACBA"));
//        System.out.println(maxUniqueLetters("ABAACBdABCA"));
        System.out.println(Arrays.toString(findAnagrams("cbaebabacd", "abc")));
    }

    /**
     * 给定一个整数数组，计算长度为 'k' 的连续子数组的最大总和
     * 暴力法
     * @param arr
     * @param k
     * @return
     */
    private static int maxSumForce(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int currSum = 0;
            for (int j = 0; j < k; j++) {
                currSum += arr[i + j];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 滑动窗口 涮循环变成单循环
     * @param arr
     * @param k
     * @return
     */
    private static int maxSumSlide(int[] arr, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        for (int j = k; j < arr.length; j++) {
            int currSum = maxSum - arr[j - k] + arr[j];
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    /**
     * https://blog.csdn.net/happy_bigqiang/article/details/95623385
     * @param s
     * @param target
     * @return
     * @throws Exception
     */
    private static String minLetters(String s, String target) throws Exception {
        int cnt = 0; //target 中字符串在s中出现过的次数
        int left = 0; //窗口左指针
        int right = 0; //窗口右指针
        int minLeft = 0;
        int minRight = 0;
        int lengthOfMin = s.length();

        char[] sArr = s.toCharArray();

        //对target 循环生成计数器
        char[] targetArr = target.toCharArray();
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : targetArr) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        for (right = 0; right < sArr.length ; right++) {
            char currChar = sArr[right];
            if (counter.containsKey(currChar)) {
                cnt = counter.get(currChar) > 0 ? cnt + 1 : cnt;
                counter.put(currChar, counter.get(currChar) - 1);
            }
            while (cnt == targetArr.length) {
                int currLengthOfMin = right - left + 1;
                if (currLengthOfMin < lengthOfMin) {
                    lengthOfMin = currLengthOfMin;
                    minLeft = left;
                    minRight = right;
                }
                char leftChar = sArr[left];
                if (counter.containsKey(leftChar)) {
                    if (counter.get(leftChar) + 1 > 0) {
                        cnt--;
                    }
                    counter.put(leftChar, counter.get(leftChar) + 1);
                }
                left++;
            }
        }
        if (right == 0) {
            return "";
        }
        return s.substring(minLeft, minRight + 1);
    }

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。(longest-substring-without-repeating-characters)
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param s
     * @return
     */
    private static int maxUniqueLetters(String s) {
        int maxLetters = 0;

        HashMap<Character, Integer> counter = new HashMap<>();

        char[] sArr = s.toCharArray();

        int left = 0, right = 0;

        for (right = 0; right < sArr.length ; right++) {
            char currChar = sArr[right];
            if (!counter.containsKey(currChar)) {
                counter.put(currChar, 1);
                continue;
            } else {
                while (left < right) {
                    char leftCahr = sArr[left++];
                    counter.remove(leftCahr);
                    if (leftCahr == sArr[right]) {
                        break;
                    }

                }
            }

            maxLetters = Math.max(maxLetters, right - left);
        }
        return maxLetters;
    }

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。(find-all-anagrams-in-a-string)
     * @param s
     * @param t
     * @return
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     */
    private static int[] findAnagrams(String s, String t) {
        int[] res = new int[s.length() - t.length()];
        int index = 0;
        int left = 0;

        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> counter = new HashMap<>();
        int tLength = tArr.length;

        for (int i = 0; i < tLength; i++) {
            counter.put(tArr[i], counter.getOrDefault(tArr[i], 0) + 1);
        }
        HashMap<Character, Integer> counterTmp = new HashMap<>();
        counterTmp.putAll(counter);

        char[] sArr = s.toCharArray();
        for (int right = 0; right < sArr.length; right++) {
            char currChar = sArr[right];
            if (!counterTmp.containsKey(currChar)) {
                left = right + 1;
                counterTmp.putAll(counter);
                continue;
            }
            while (counterTmp.get(currChar) <= 0) {
                char leftChar = sArr[left++];
                counterTmp.put(leftChar, counterTmp.get(leftChar) + 1);
                if (leftChar == currChar) {
                    continue;
                }
            }
            if (counterTmp.containsKey(currChar) && counterTmp.get(currChar) > 0) {
                counterTmp.put(currChar, counterTmp.get(currChar) - 1);
            }
            if (right - left + 1 == tLength) {
                char leftChar = sArr[left++];
                counterTmp.put(leftChar, counterTmp.get(leftChar) + 1);
                res[index++] = right - tLength + 1;
            }

        }

        return res;
    }
}
