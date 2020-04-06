package offer;

import org.omg.CORBA.INTERNAL;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/
 * 862. 和至少为 K 的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 *
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 *
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 *
 */
public class ShortestSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{2,-1,2};
        System.out.println((new ShortestSubarray()).shortestSubarray(nums,3));
    }
    /**
     * P为前缀和数组
     * 特性1  若x1 且P[1] >= P2,不满足P1 + K < P2,1 <= K <= 10 ^ 9 ，维护一个单调递增的队列
     * 特性2  若P2 - P1 得到最小的K，则移除P1，因为P3 > P2 ,必然 P3坐标- P1坐标 > P2坐标- P1坐标
     * @param A
     * @param K
     * @return
     */
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        long[] sums = new long[len];
        for (int i = 0; i < len; i++) {
            sums[i] = i == 0 ? A[0] : sums[i - 1] + A[i];
        }

        Deque<Integer> queue = new LinkedList<>();
        queue.add(-1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            while (!queue.isEmpty()) {
                long tmp =  queue.peekLast() == -1 ? 0 : sums[queue.peekLast()];
                 if (sums[i] <= tmp) {
                     queue.removeLast();
                 } else {
                     break;
                 }
            }

            while (!queue.isEmpty()) {
                long tmp =  queue.peekFirst() == -1 ? 0 : sums[queue.peekFirst()];

                if (sums[i] - tmp >= K) {
                    ans = Math.min(ans, i - queue.removeFirst());
                } else {
                    break;
                }
            }
            queue.add(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
