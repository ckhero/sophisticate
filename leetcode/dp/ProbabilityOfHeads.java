package dp;

/**
 * 1230. 抛掷硬币
 * 有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。
 *
 * 请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。
 *
 *
 *
 * 示例 1：
 *
 * 输入：prob = [0.4], target = 1
 * 输出：0.40000
 * 示例 2：
 *
 * 输入：prob = [0.5,0.5,0.5,0.5,0.5], target = 0
 * 输出：0.03125
 *
 *
 * 提示：
 *
 * 1 <= prob.length <= 1000
 * 0 <= prob[i] <= 1
 * 0 <= target <= prob.length
 * 如果答案与标准答案的误差在 10^-5 内，则被视为正确答案。
 */
public class ProbabilityOfHeads {
    public static void main(String[] args) {
//        double[] prod  = new double[]{0.4};
//        double[] prod  = new double[]{0.5,0.5,0.5,0.5,0.5};
        double[] prod  = new double[]{0.2,0.8,0,0.3,0.5};
        System.out.println((new ProbabilityOfHeads()).probabilityOfHeads(prod, 3));
    }

    /**
     * * 01 背包
     *  f(i, j) = f(i - 1, j) * (1- rate) + f(i - 1, j - 1) * rate
     * @param prob
     * @param target
     * @return
     */
    public double probabilityOfHeads(double[] prob, int target) {
        int len = prob.length;
        if (len == 0) return 0;
        double[][] dp = initDP(prob, target);
        for (int i = 1; i <= len ; i++) {
            for (int j = 1; j <= target; j++) {
                double rate  = prob[i - 1];
                double a = dp[i - 1][j];
                double b = dp[i - 1][j - 1];
                dp[i][j] = dp[i - 1][j] * (1- rate) + dp[i - 1][j - 1] * rate;
            }
        }
        return dp[len][target];
    }

    public double[][] initDP(double[] prob, int target) {
        int len = prob.length;
        double[][] dp = new double[len + 1][target + 1];
        //第一行初始化为 1
        dp[0][0] = 1;
        for (int i = 1; i <= target ; i++) {
            dp[0][i] = 0;
        }
        // 第一列开始计算
        for (int i = 1; i <= len ; i++) {
            dp[i][0] = (1 - prob[i - 1]) * dp[i - 1][0];
        }
        return dp;
    }
}
