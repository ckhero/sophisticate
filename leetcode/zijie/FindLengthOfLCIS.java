package zijie;

public class FindLengthOfLCIS {
    public static void main(String[] args) {
        System.out.println((new FindLengthOfLCIS()).findLengthOfLCIS(new int[]{1,3,5,7}));
        System.out.println((new FindLengthOfLCIS()).findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }
        int left = 0, right = 1;
        int maxLen = 1;
        int tmpLen = 1;

        while (right < len) {
            if (nums[right] > nums[right - 1]) {
                tmpLen++;
            } else {
                tmpLen = 1;
            }
            right++;

            maxLen = Math.max(tmpLen, maxLen);
        }
        return maxLen;
    }
}
