
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));

    }
    public static int lengthOfLongestSubstring(String s) {
        int left = -1;
        int len = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (map.containsKey(curr)) {
                // 因为map记录所有的历史数据，存在的curr可能在窗口外；比如abba到第二a的时候left在第二b但是a的上一个位置在 0
                left = Math.max(left, map.get(curr));
            }
            map.put(curr, i);
            max = Math.max(max, i - left);
        }
        return max;
    }
//    private static int lengthOfLongestSubstring(String s) {
//        char[] sArr = s.toCharArray();
//        HashSet<Character> count = new HashSet<>();
//        int left = 0, right = 0, ans = 0;
//        while (left < sArr.length && right < sArr.length) {
//            if (!count.contains(sArr[right])) {
//                count.add(sArr[right++]);
//                ans = Math.max(right - left, ans);
//            } else {
//                count.remove(sArr[left++]);
//            }
//        }
//        return ans;
//    }
}
