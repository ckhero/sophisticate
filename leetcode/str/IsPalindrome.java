package str;

public class IsPalindrome {
    public static void main(String[] args) {

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("9P"));
    }

    private static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] sArr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!((sArr[left] >= 97 && sArr[left] < 122) || (sArr[left] >= 48 && sArr[left] < 58))) {
                left++;
                continue;
            }
            if (!((sArr[right] >= 97 && sArr[right] < 122) || (sArr[right] >= 48 && sArr[right] < 58))) {
                right--;
                continue;
            }
            if (sArr[left++] != sArr[right--]) {
                return false;
            }
        }
        return true;
    }
}
