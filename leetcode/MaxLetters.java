import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxLetters {
    public static void main(String[] args) {
        String str = "aaaeaasddda";
//        maxFreq(str, 2, 2, 3);
        Integer a = 2;
        Integer b = 1;

        int[] arr = new int[2];
        System.out.println(Arrays.toString(arr));
        System.out.println(a);
        System.out.println(b);
        swap(arr, a, b);
        System.out.println(Arrays.toString(arr));
        System.out.println(a);
        System.out.println(b);
    }

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> counts = new HashMap<>();
        int n = s.length();
        char[] sArr = s.toCharArray();
        int[] hash = new int[26];
        
        int l = 0, res = 0, unique = 0;
        for (int r = 0; r < n ; r++) {
            if (hash[sArr[r] - 'a']++ == 0) {
                unique++;
            }
            while (unique > maxLetters || r - l + 1 > minSize) {
                if (hash[sArr[l++] - 'a']-- == 1) {
                    unique--;
                }
            }
        }
        System.out.println(unique);
        return 1;
    }

    private static void swap(int[] arr, Integer a, Integer b) {
        Integer tmp = a;
        a = b;
        b = tmp;
        arr[0] = a;
        arr[1] = b;
    }
}
