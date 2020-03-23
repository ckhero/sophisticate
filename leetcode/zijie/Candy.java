package zijie;

import java.util.Arrays;

public class Candy {
    public static void main(String[] args) {


    }

    public int candy(int[] ratings) {
        int candies = 0;
        int[] left2Right = new int[ratings.length];
        int[] right2Left = new int[ratings.length];
        Arrays.fill(left2Right, 1);
        Arrays.fill(right2Left, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left2Right[i] = left2Right[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right2Left[i] = right2Left[i + 1] + 1;
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            candies += Math.max(left2Right[i], right2Left[i]);
        }
        return candies;
    }
}
