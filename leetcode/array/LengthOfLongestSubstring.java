package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("ba"));

    }

    private static int lengthOfLongestSubstring(String s) {
        char[] sArr = s.toCharArray();
        HashSet<Character> count = new HashSet<>();
        int left = 0, right = 0, ans = 0;
        while (left < sArr.length && right < sArr.length) {
            if (!count.contains(sArr[right])) {
                count.add(sArr[right++]);
                ans = Math.max(right - left, ans);
            } else {
                count.remove(sArr[left++]);
            }
        }
        return ans;
    }
}
