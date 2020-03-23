package str;

import java.util.HashMap;

public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(        Integer.parseInt("aa", 16));
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    private static int firstUniqChar(String s) {
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length - 1; i++) {
//            boolean flag = true;
//            for (int j = i + 1; j < chars.length; j++) {
//                if (chars[i] == chars[j]) {
//                    flag = false;
//                }
//            }
//            if (flag) {
//                return i;
//            }
//        }
//        return -1;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
