package zijie;

public class Trap {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println((new Trap()).trap2(nums));
    }

    public int trap(int[] height) {
        int len = height.length;
        int left = 0, leftMax = 0, rightMax = 0, ans = 0;
        int right = len - 1;
        while (left < right) {
            int currLeft = height[left];
            int currRight = height[right];
            if (currLeft <= currRight) {
                if (currLeft >= leftMax) {
                    leftMax = currLeft;
                } else  {
                    ans += leftMax - currLeft;
                }
                left++;
            } else {
                if (currRight >= rightMax) {
                    rightMax = currRight;
                } else {
                    ans += rightMax - currRight;
                }
                right--;
            }
        }
        return ans;
    }

        /**
     * 哪边低从那边开始蓄水，低于 max的开始蓄水
     * @param height
     * @return
     */
    private static int trap2(int[] height) {
        int ans = 0, left = 0, leftMax = 0, right = height.length - 1, rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax ) {
                    leftMax = height[left];
                } else  {
                    ans += leftMax - height[left];

                }
                left++;
            } else {
                if (height[right] >= rightMax ) {
                    rightMax = height[right];
                } else {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
