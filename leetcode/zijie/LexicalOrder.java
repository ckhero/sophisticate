package zijie;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 */
public class LexicalOrder {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(1));
    }

    private static List<Integer> lexicalOrder(int n) {
        helper(null, n);

        return res;
    }
    static List<Integer> res = new ArrayList<>();

    static void helper(Integer pre, int n) {
        if (pre != null && pre > n) {
            return;
        }
        if (pre != null) {
            res.add(pre);
        }

        for (int i = 0; i < 10; i++) {
            if (pre == null) {
                if (i == 0) {
                    continue;
                } else {
                    pre = 0;
                }
            }
            helper(pre * 10 + i, n);
        }
    }
}
