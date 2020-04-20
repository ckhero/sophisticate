package zijie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/meeting-scheduler/
 * 1229. 安排会议日程
 * 你是一名行政助理，手里有两位客户的空闲时间表：slots1 和 slots2，以及会议的预计持续时间 duration，请你为他们安排合适的会议时间。
 *
 * 「会议时间」是两位客户都有空参加，并且持续时间能够满足预计时间 duration 的 最早的时间间隔。
 *
 * 如果没有满足要求的会议时间，就请返回一个 空数组。
 *
 *
 *
 * 「空闲时间」的格式是 [start, end]，由开始时间 start 和结束时间 end 组成，表示从 start 开始，到 end 结束。
 *
 * 题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间 [start1, end1] 和 [start2, end2]，要么 start1 > end2，要么 start2 > end1。
 *
 *
 *
 * 示例 1：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
 * 输出：[60,68]
 * 示例 2：
 *
 * 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
 * 输出：[]
 */
public class MinAvailableDuration {
    public static void main(String[] args) {
        int[][] aa = new int[][]{{0,2}};
        int[][] bb = new int[][]{{1,3}};
        (new MinAvailableDuration()).minAvailableDuration(aa, bb, 2);
    }
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Comparator cmp = new MyComparator();
        Arrays.sort(slots1, cmp);
        Arrays.sort(slots2, cmp);
        int one = 0;
        int two = 0;
        List<Integer> ans = new ArrayList<>();
        while (one < slots1.length && two < slots2.length) {
            if (slots2[two][1] - duration < slots1[one][0] || slots2[two][1] - duration < slots2[two][0]) {
                two++;
                continue;
            }
            if (slots1[one][1] - duration < slots2[two][0] || slots1[one][1] - duration < slots1[one][0]) {
                one++;
                continue;
            }
            int start = Math.max(slots1[one][0], slots2[two][0]);
            ans.add(start);
            ans.add(start + duration);
            break;
        }
        return ans;
    }
    class MyComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        }
    }

}
