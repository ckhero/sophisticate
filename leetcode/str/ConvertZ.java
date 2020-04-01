package str;

import java.util.List;

public class ConvertZ {

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

    private static String convert(String s, int numRows) {
        String res = String.valueOf(s.charAt(0));
//        for (int j = 0; j < numRows; j++) {
//            res += String.
//        }
        return res;
    }

    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) {
            return;
        }
        int left = 0;
        int right = len -1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

//    public List<List<Integer>> generate(int numRows) {
//
//    }
}
