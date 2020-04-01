package array;

/**
 * 1014. 最佳观光组合
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 * 通过次数3,720提交次数7,826
 */
public class MaxScoreSightseeingPair {
    public static void main(String[] args) {
//        int[] A = new int[]{8,1,5,2,6};
        int[] A = new int[]{1,3,5};
        System.out.println((new MaxScoreSightseeingPair()).maxScoreSightseeingPair(A));
    }

    /**
     * A[i] + A[j] + i - j 分成 两部分
     * A[i] + i  A[j] - j
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair(int[] A) {
        int len = A.length;
        int ans =  0;
        int preMax =  A[0];
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, preMax  +  A[i] - i);
            preMax = Math.max(preMax,  A[i] +  i);

        }
        return ans;
    }

    /**
     * 暴力 会超时
     * @param A
     * @return
     */
    public int maxScoreSightseeingPair2(int[] A) {
        int len  = A.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(A[i] + A[j] + i - j, max);
            }
        }
        return max;
    }
}
