/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/2
 * Time: 6:26 PM
 */

import java.util.*;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        List<Integer> ans = (new TopKFrequent()).topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ans.toArray()));

    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        if (nums.length == 0 ) {
            return new ArrayList<>();
        }
        //计算每个元素的出现频率
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        //最小堆  + 判断原理
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry.getKey());
                continue;
            }
            if (count.get(minHeap.peek()) < entry.getValue()) {
                minHeap.poll();
                minHeap.add(entry.getKey());
            }

        }
        //组装结果
        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        return res;
    }
}
