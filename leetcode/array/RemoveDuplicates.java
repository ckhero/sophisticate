package array;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        int res = solution(nums);
        for (int i = 0; i < res; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int solution(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[index++] = nums[i];
            }
        }
        for (int j = ++index; j < nums.length; j++) {
            nums[j] = 0 ;
        }
        return index;
    }
}
