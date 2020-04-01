package dp;

public class KnightProbability {
    public static void main(String[] args) {
        System.out.println((new KnightProbability()).knightProbability(3, 2, 0, 0));
    }
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K];
        //先算出  每个位置 走一步的 存活概率
        // 两步的存活概率
        for (int i = 0; i < K; i++) {
            for (int rx = 0; rx < N; rx++) {
            for (int cx = 0; cx < N; cx++) {

                    double rate = (rx + 2 < N && cx + 1 < N) ? dp[rx+2][cx+1][i] : 0;
                    rate += (rx + 2 < N && cx - 1 >= 0) ? dp[rx+2][cx-1][i] : 0;
                    rate += (rx - 2 >= 0 && cx + 1 < N) ? dp[rx-2][cx+1][i] : 0;
                    rate += (rx - 2 >= 0 && cx - 1 >= 0) ? dp[rx-2][cx-1][i] : 0;
                    rate += (rx + 1 < N && cx +2 < N) ? dp[rx+1][cx+2][i] : 0;
                    rate += (rx - 1 >= 0 && cx +2 < N) ? dp[rx-1][cx+2][i] : 0;
                    rate += (rx + 1 < N && cx - 2 >= 0) ? dp[rx+1][cx-2][i] : 0;
                    rate += (rx - 1 >= 0 && cx - 2 >= 0) ? dp[rx-1][cx-2][i] : 0;
                    dp[rx][cx][i] = rate / 8;
                }
            }
        }
        return 1;
    }

    /**
     * 递归
     * @param N
     * @param K
     * @param r
     * @param c
     * @param step
     * @return
     */
    public double getRate(int N, int K, int r, int c, int step) {
        //越界 直接返回
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return 0;
        }
        if (step > K) {
            return 1;
        }

        double rate = 0;
        rate += getRate(N, K, r + 2, c + 1, step +1);
        rate += getRate(N, K, r + 2, c - 1, step +1);
        rate += getRate(N, K, r - 2, c + 1, step +1);
        rate += getRate(N, K, r - 2, c - 1, step +1);
        rate += getRate(N, K, r - 1, c + 2, step +1);
        rate += getRate(N, K, r + 1, c + 2, step +1);
        rate += getRate(N, K, r + 1, c - 2, step +1);
        rate += getRate(N, K, r - 1, c - 2, step +1);
        return rate / 8;
    }

}
