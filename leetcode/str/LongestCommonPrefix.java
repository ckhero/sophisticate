package str;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{};
        System.out.println(longestCommonPrefix(strs));
    }

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String commonPre = strs[0];
        int index = commonPre.length();
        for (int i = 1; i < strs.length; i++) {
            commonPre = commonPre.substring(0, index);
            index = 0;
            if (commonPre.length() == 0) {
                break;
            }

            while (index < commonPre.length() && index < strs[i].length()) {
                if (commonPre.charAt(index) != strs[i].charAt(index)) {
                    break;
                } else {
                    index++;
                }
            }
        }
        return commonPre.substring(0, index);
    }
}
