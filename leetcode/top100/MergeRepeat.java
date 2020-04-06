import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeRepeat {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.toString((new MergeRepeat()).merge(nums)));
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] ans = new int[intervals.length][2];
        int idx = 1;
        ans[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > ans[idx - 1][1]) {
                ans[idx++] = intervals[i];
            } else {
                ans[idx - 1][1] = Math.max(ans[idx - 1][1], intervals[i][1]);
            }
        }
        return Arrays.copyOfRange(ans, 0 , idx);
    }
}
