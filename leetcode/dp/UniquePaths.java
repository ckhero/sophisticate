package dp;

/**
 * f(m,n)
 * f(0,0) = 1
 * f(0,1) = 1
 * f(1,0) = 1
 * f(1,1) = 2
 *
 * f(m, n) = f(m - 1, n - 1)
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 2));
    }
    private static int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m - 1][n - 1];
    }
}
