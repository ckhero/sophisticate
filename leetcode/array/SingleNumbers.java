package array;

public class SingleNumbers {
    public static void main(String[] args) {
        System.out.println((new SingleNumbers().singleNumbers(new int[]{4,1,4,6})));
    }
    public int[] singleNumbers(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        //求最低位为1的书
        int onePos = tmp&(-tmp);
        int ans1 = 0;
        int ans2 = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
            if ((onePos & nums[i]) == onePos) {
                ans1 ^= nums[i];
            } else {
                ans2 ^= nums[i];

            }
        }
        return new int[]{ans1, ans2};
    }
}
