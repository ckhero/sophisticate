/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/2
 * Time: 5:13 PM
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 通过次数39,126提交次数65,532
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = (new DailyTemperatures()).dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
        System.out.println(1 ^ 4);
    }

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 0) {
            return new int[]{};
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty()) {
                int idx = stack.peek();
                if (T[i] > T[idx]) {
                    T[idx] = i - idx;
                    stack.pop();
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            T[stack.pop()] = 0;
        }
        return T;
    }
}

