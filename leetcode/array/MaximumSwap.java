package array;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 */
public class MaximumSwap {
    public static void main(String[] args) {
//        System.out.println((new MaximumSwap()).maximumSwap(2736));
//        System.out.println((new MaximumSwap()).maximumSwap(1993));
        System.out.println((new MaximumSwap()).maximumSwap(120));
//        System.out.println((new MaximumSwap()).maximumSwap(19931105));
//        System.out.println((new MaximumSwap()).maximumSwap(22341345));
//        System.out.println((new MaximumSwap()).maximumSwap(98368));
//        System.out.println((new MaximumSwap()).maximumSwap(9932));
//        System.out.println((new MaximumSwap()).maximumSwap(98368));
    }

    /**
     * 找出递增前的最小的一个数，然后 找到他后面最大的一个数，
     * 再找到 最大数前面比他小的第一个数
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int min = 0;
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = i;
                i++;
                while (i < nums.length) {
                    if (nums[i] >= nums[max]) {
                        max = i;
                    }
                    i++;
                }
                break;
            }
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        for (int i = 0; i < max; i++) {
            if (nums[i] < nums[max]) {
                min = i;
                break;
            }
        }
        if (min < max) {
            char tmp = nums[min];
            nums[min] = nums[max];
            nums[max] = tmp;
        }
        return Integer.parseInt(new String(nums));
    }

}
