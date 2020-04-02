/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2020/4/2
 * Time: 11:26 AM
 */

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class MaxProfitWithCold {

    public static void main(String[] args) {
//        int[] prices = new int[]{1,2,3,0,2};
        int[] prices = new int[]{2,1,2,0,1};

        System.out.println((new MaxProfitWithCold()).maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int pre0 = 0, pre1 = Integer.MIN_VALUE, ppre0 = 0;
        for (int i = 0; i < len; i++) {
            int tmp = pre0;
            pre0 = Math.max(pre0, pre1 + prices[i]);
            pre1 = Math.max(pre1, ppre0 - prices[i]);
            ppre0 = tmp;
        }
        return pre0;
    }
}
