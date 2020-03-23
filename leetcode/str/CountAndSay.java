package str;

import sun.tools.java.Parser;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return String.valueOf(1);
        }
        if (n == 2) {
            return String.valueOf(11);
        }
        int k = 11;
        String str = "11";
        int index = 1;

        for (int i = 0; i < n - 2; i++) {
            char[] arr = str.toCharArray();
            str = "";
            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] != arr[j+1]) {
                    str += String.valueOf(index) + String.valueOf(arr[j]);
                    index = 1;
                } else {
                    index++;
                }
            }
            str += String.valueOf(index) + String.valueOf(arr[arr.length - 1]);
            index = 1;

        }
        return str;
    }
}
