package array;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(solution(prices));
    }

    private static int solution(int[] prices) {
        int profit = 0;
        int i = 0;
        int j = 1;
        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                profit += prices[j] - prices[i];
            }
            j++;
            i++;
        }
        return profit;
    }
}
