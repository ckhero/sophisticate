package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString((new Permutation()).permutation("abc")));
    }
    public String[] permutation(String s) {
        if (s.isEmpty()) return new String[]{};
        char[] aa = s.toCharArray();
        Arrays.sort(aa);
        List<String> ans = new ArrayList<>();
        helper(aa, new StringBuilder(), ans, 0);
        return ans.toArray(new String[ans.size()]);
    }

    public void helper(char[] s, StringBuilder path, List<String> ans, int k) {
        if (k == s.length) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '/' || (i > 0 && s[i - 1] == s[i])) continue;
            char tmp = s[i];
            s[i] = '/';
            path.append(tmp);
            helper(s, path, ans, k + 1);
            path.deleteCharAt(path.length() - 1);
            s[i] = tmp;
        }
    }
}
