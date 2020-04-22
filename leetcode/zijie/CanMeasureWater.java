/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/22
 * Time: 11:46 AM
 */

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 365. 水壶问题
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 * 通过次数22,416提交次数63,759
 */
public class CanMeasureWater {
    public static void main(String[] args) {

//        System.out.println((new CanMeasureWater()).canMeasureWater(0, 0, 1));
//        System.out.println((new CanMeasureWater()).canMeasureWater(0, 0, 1));
//        System.out.println((new CanMeasureWater()).canMeasureWater(34, 5, 6));
//        System.out.println((new CanMeasureWater()).canMeasureWater(2, 6, 5));
//        System.out.println((new CanMeasureWater()).canMeasureWater(0, 2, 1));
//        System.out.println((new CanMeasureWater()).canMeasureWater(1, 0, 0));
//        System.out.println((new CanMeasureWater()).canMeasureWater(1, 1, 12));
        System.out.println((new CanMeasureWater()).canMeasureWater(13, 11, 1));
//        System.out.println((new CanMeasureWater()).canMeasureWater(3, 5, 4));
//        System.out.println((new CanMeasureWater()).canMeasureWater(2, 6, 5));
        System.out.println();
    }
    private boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (z == 0) {
            return true;
        }
        if (x ==0 && y == 0) {
            return z == 0;
        }

        int tmp = x;
        int tmp2 = y;
        if (x !=0 && y !=0) {
            if ( x > y) {
                tmp = x % y;
                tmp2 = y;
            } else {
                tmp = y % x;
                tmp2 = x;
            }
        }
        int[] arr = new int[]{tmp, tmp2, Math.abs(tmp - tmp2)};
        return helper(arr, z);

    }
    private boolean helper(int[] arr, int z) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                continue;
            }
            z -= arr[i];

            if (z == 0) {
                return true;
            } else if (z > 0) {
                if (helper(arr, z)) {
                    return true;
                }
            }
            z += arr[i];
        }
        return false;
    }
}
