import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class FindKthLargestK {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        int ans = (new FindKthLargestK()).findKthLargest(nums, 2);
        System.out.println(ans);
    }
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> minhHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (!minhHeap.isEmpty() && minhHeap.size() >= k) {
                if (minhHeap.peek() > num) {
                    continue;
                }
                minhHeap.poll();
            }
            minhHeap.add(num);
        }
        return minhHeap.peek();
    }
}
