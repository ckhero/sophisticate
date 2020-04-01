/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/1
 * Time: 1:37 PM
 */

import java.util.*;

/**
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。
 *
 *
 *
 * 示例 ：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 */
public class LeastInterval {
    public static void main(String[] args) throws Exception{
//        char[] aa = new char[]{'A','A','A','B','B','B','C'};
//        char[] aa = new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
        char[] aa = new char[]{'A','A','B','B'};
        System.out.println((new LeastInterval()).leastInterval(aa, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (len == 0) {
            return 0;
        }
        char[] count = new char[26];
        for (int i = 0; i < len; i++) {
            count[tasks[i] - 'A'] += 1;
        }
        Arrays.sort(count);
        int ans = 0;
        while (count[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (count[25] == 0) {
                    break;
                }
                if (count[25 - i] > 0 && i < 26) {
                    count[25 -i]--;
                }
                ans++;
                i++;
            }
            Arrays.sort(count);

        }
        return ans;
    }
}
