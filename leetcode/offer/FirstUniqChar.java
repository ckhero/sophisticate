package offer;

import java.util.HashMap;

public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println((new FirstUniqChar()).numWays(98));
    }
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int ppre = 0;
        int pre = 1;
        int curr =  0;
        for (int i = 2; i <= n; i++) {
            curr = pre + ppre;
            int tmp = pre;
            ppre = tmp;
            pre = curr;
        }
        return curr % 1000000007;
    }

    public int numWays(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }
        //(x+y)⊙p=(x⊙p+y⊙p)⊙p
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        return dp[n];
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i] + nums[i - 1];
            }
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            int curr = prices[i];
            if (curr < minPrice) {
                minPrice = curr;
            } else {
                maxProfit = Math.max(maxProfit, curr - minPrice);
            }
        }
        return maxProfit;
    }
}
