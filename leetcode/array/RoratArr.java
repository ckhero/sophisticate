package array;

/**
 *
 */
public class RoratArr {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        solution(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static void solution(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < k; i++) {

            int next = 0;
            for (int j = 0; j < len; j++) {
                if (j == 0 ) {
                    next = nums[0];
                }
                if ((j + 1) == len)  {
                    nums[0] = next;
                    continue;
                }
                int tmp = nums[j + 1];
                nums[j + 1] = next;
                next = tmp;
            }
        }
    }

    public void rotateMatrix(int[][] matrix) {
        int k = matrix[0].length;
        // 转置矩阵
        for (int i = 0; i < k; i++) {
            for (int j = i; j < k; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //反转每一行
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k - j - 1];
                matrix[i][k - j - 1] = tmp;
            }
        }
    }

    /**
     * 反转字符串
     * @param s
     */
    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = tmp;
        }
    }
}
