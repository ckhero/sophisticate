package array;

public class PlusOne {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,1};
        int[] res = plusOne(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
