package array;

import java.util.Arrays;

/**
 * 面试题04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *
 *
 * 限制：
 *
 * 0 <= n <= 1000
 */
public class FindNumberIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
//        System.out.println((new FindNumberIn2DArray()).findNumberIn2DArray(matrix, 5));
        System.out.println((new FindNumberIn2DArray().search(new int[]{3,1})));
    }

    /**
     * 从又上角开始查，比他大的下移，不然左移
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int currRow = 0;
        int currCol = cols - 1;
        while (currRow < rows && currCol >= 0) {
            int curr = matrix[currRow][currCol];
            if ( curr == target) {
                return true;
            }
            if (curr > target) {
                currCol++;
            } else {
                currCol--;
            }
        }
        return false;
    }

    /**
     * 1 2 3 4 5
     * @return
     */
    public int search(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (numbers[right] > numbers[mid]) {
                right = mid;
            } else if (numbers[right] < numbers[mid]) {
                left = mid + 1;
            } else {
                right--;
            }

        }
        return numbers[right];
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }
}
