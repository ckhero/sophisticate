package zijie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 回朔
 * 93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println((new RestoreIpAddresses()).restoreIpAddresses("1111"));
    }


    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        backtrack(-1, 3);
        return ans;
    }

    List<String> ans = new ArrayList<>();
    LinkedList<String> segments = new LinkedList<>();
    String s;

    public void  backtrack(int prePos, int dots) {
        int maxPos = Math.min(s.length(), prePos + 4);
        for (int currPos = prePos + 1; currPos < maxPos; currPos++) {
            System.out.println(prePos);
            System.out.println(currPos);
            String segment = s.substring(prePos + 1, currPos + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0 ) {
                    output(currPos);
                } else {
                    backtrack(currPos, dots - 1);
                }
                segments.removeLast();
            }
        }
    }
    public void output(int currPos) {
        String segment = s.substring(currPos + 1);
        if (valid(segment)) {
            segments.add(segment);
            ans.add(String.join(".", segments));
            segments.removeLast();
        }
    }
    public boolean valid(String segment) {
        int len = segment.length();
        if (len > 3 || len == 0) {
            return false;
        }
        return segment.charAt(0) == '0' ? len == 1 : Integer.parseInt(segment) <= 255;
    }
}
