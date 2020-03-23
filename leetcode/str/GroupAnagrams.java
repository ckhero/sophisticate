package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] sChar = strs[i].toCharArray();
            Arrays.sort(sChar);
            String key = new String(sChar);
            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(strs[i]);
        }
        return new ArrayList<>(res.values());
    }
}
