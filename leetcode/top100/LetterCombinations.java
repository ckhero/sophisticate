/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/8
 * Time: 4:37 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LetterCombinations {
    public static void main(String[] args) {

        List<String> ans = (new LetterCombinations()).letterCombinations("23");
        System.out.println();
    }
    HashMap<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        initMap();
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), digits, 0);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder curr, String digits, int idx) {
        if (digits.length() == idx) {
            ans.add(curr.toString());
            return;
        }
        String currCahrs = map.get(digits.charAt(idx));
        for (int i = 0; i < currCahrs.length(); i++) {
            curr.append(currCahrs.charAt(i));
            backtrack(ans, curr, digits, idx + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    private void initMap(){
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}
