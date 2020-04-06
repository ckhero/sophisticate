package zijie;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
 * 786. 第 K 个最小的素数分数
 * 一个已排序好的表 A，其包含 1 和其他一些素数.  当列表中的每一个 p<q 时，我们可以构造一个分数 p/q 。
 *
 * 那么第 k 个最小的分数是多少呢?  以整数数组的形式返回你的答案, 这里 answer[0] = p 且 answer[1] = q.
 *
 * 示例:
 * 输入: A = [1, 2, 3, 5], K = 3
 * 输出: [2, 5]
 * 解释:
 * 已构造好的分数,排序后如下所示:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * 很明显第三个最小的分数是 2/5.
 *
 * 输入: A = [1, 7], K = 1
 * 输出: [1, 7]
 */
public class KthSmallestPrimeFraction {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        System.out.println(Arrays.toString((new KthSmallestPrimeFraction()).kthSmallestPrimeFraction(nums, 3)));
    }
    public int[] kthSmallestPrimeFraction(int[] A, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return compare2(o2, o1) ? 1 : -1;
            }
        });
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int[] newItem = new int[]{A[i], A[j]};
                if (!maxHeap.isEmpty() && maxHeap.size() >= K) {
                    int[] item = maxHeap.peek();

                    if (compare2(newItem, item)) {
                        continue;
                    }
                    maxHeap.poll();
                }
                maxHeap.add(newItem);
            }
        }

        return maxHeap.peek();
    }
    private boolean compare2(int[] o1, int[] o2) {
        return  (double)o1[0] / o1[1] - (double) o2[0] / o2[1] > 0;
    }
}
