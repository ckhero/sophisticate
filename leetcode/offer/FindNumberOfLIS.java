package offer;

public class FindNumberOfLIS {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,3,5,4,7,2};
//        int[] nums = new int[]{3,1,2};
//        int[] nums = new int[]{2,2,2};
//        int[] nums = new int[]{1,2,3,1,2,3,1,2,3};
        System.out.println((new FindNumberOfLIS()).findNumberOfLIS(nums));
    }
    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int[] dp = new int[len];
        int[] tmpMax = new int[len];
        int max = 1;
        int maxNum = 1;
        tmpMax[0] = 1;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int maxVal = 0;
            int currMax = 1;
            int currMaxNum = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    maxVal = Math.max(dp[j], maxVal);
                    if (dp[j] + 1 == currMax) {
                        currMaxNum += tmpMax[j];
                    } else if (dp[j] + 1 > currMax) {
                        currMax = dp[j] + 1;
                        currMaxNum = tmpMax[j];
                    }
                }
            }
            tmpMax[i] = currMaxNum;
            maxVal += 1;
            if (currMax == max) {
                maxNum += currMaxNum;
            }
            if (currMax > max) {
                maxNum = currMaxNum;
                max = currMax;
            }
            dp[i] = maxVal;

        }

        return maxNum;
    }
}
