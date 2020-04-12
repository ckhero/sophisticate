package zijie;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/candy/
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Candy {
    public static void main(String[] args) {


    }

    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int candies = left[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            candies += Math.max(left[i], right[i]);
        }
        return candies;
    }

//    public int candy(int[] ratings) {
//        int candies = 0;
//        int[] left2Right = new int[ratings.length];
//        int[] right2Left = new int[ratings.length];
//        Arrays.fill(left2Right, 1);
//        Arrays.fill(right2Left, 1);
//        for (int i = 1; i < ratings.length; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                left2Right[i] = left2Right[i - 1] + 1;
//            }
//        }
//        for (int i = ratings.length - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                right2Left[i] = right2Left[i + 1] + 1;
//            }
//        }
//
//        for (int i = 0; i < ratings.length; i++) {
//            candies += Math.max(left2Right[i], right2Left[i]);
//        }
//        return candies;
//    }
}
