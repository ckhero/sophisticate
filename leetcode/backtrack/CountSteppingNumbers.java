package backtrack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 1215. 步进数
 * 如果一个整数上的每一位数字与其相邻位上的数字的绝对差都是 1，那么这个数就是一个「步进数」。
 *
 * 例如，321 是一个步进数，而 421 不是。0
 * 1000000000
 *
 * 给你两个整数，low 和 high，请你找出在 [low, high] 范围内的所有步进数，并返回 排序后 的结果。
 *
 *
 *
 * 示例：
 *
 * 输入：low = 0, high = 21
 * 输出：[0,1,2,3,4,5,6,7,8,9,10,12,21]
 */
public class CountSteppingNumbers {
    public static void main(String[] args) {
        List<Integer> aa = (new CountSteppingNumbers()).countSteppingNumbers(0, 1000000000);
        System.out.println(11);

    }
    public List<Integer> countSteppingNumbers(int low, int high) {
        long[] dp = new long[high+1];
        List<Integer> ans = new ArrayList<>();
        for (int i = low; i <= high ; i++) {
            if (check(i, dp)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean check(int num, long[] dp) {
        if (num <= 10) {
            return true;
        }
        int tmp = num;
        int pre = num % 10;
        while (num > 10) {
            num /= 10;
            int next = num % 10;
            if (Math.abs(next - pre) != 1) {
                return false;
            }
            if (dp[num] == 1) {
                break;
            }
            pre = next;
        }
        dp[tmp] = 1;
        return true;
    }

    public void backTrack(int low, int high, List<Integer> res) {
        if (low > high) {
            return;
        }
        for (int i = low; i <= high ; i++) {

        }
    }
}
