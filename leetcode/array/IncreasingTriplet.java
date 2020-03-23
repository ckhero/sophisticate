package array;

/**
 * f(1) = 0;
 * f(2) = 0;
 * f(3) = 1 < 2 < 3;
 * f(4) = 1 < 2 < 3 || 2 < 3 < 4
 * f(5) = 1 < 2 < 3 || 2 < 3 < 4 || 1 < 2 < 4 || 1 < 2 < 5  || 1 < 4 < 5 || 1 < 3 < 5 < || 2 < 3 < 5
 * f(6) = 1 < 2 < 3 || 2 < 3 < 4 || 1 < 2 < 4 || 1 < 2 < 5  || 1 < 4 < 5 || 1 < 3 < 5 < || 2 < 3 < 5 || 1 < 2 < 6 || 1 < 3
 */
public class IncreasingTriplet {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{6,7,5,9}));
    }

    private static boolean increasingTriplet(int[] nums) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (m1 >= nums[i]) {
                m1 = nums[i];
            } else if (m2 >= nums[i]){
                m2 = nums[i];

            } else {
                return true;
            }
        }

        return false;
    }
}
