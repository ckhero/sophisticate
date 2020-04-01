package zijie;

/**
 * 564. 寻找最近的回文数
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 *
 * “最近的”定义为两个整数差的绝对值最小。
 *
 * 示例 1:
 *
 * 输入: "123"
 * 输出: "121"
 * 注意:
 *
 * n 是由字符串表示的正整数，其长度不超过18。
 * 如果有多个结果，返回最小的那个。
 */
public class NearestPalindromic {
    public static void main(String[] args) {
//        System.out.println((new NearestPalindromic()).nearestPalindromic("123"));
        System.out.println((new NearestPalindromic()).nearestPalindromic("121"));
    }
    public String nearestPalindromic(String n) {
        if (Integer.parseInt(n) < 10) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }
        char[] arr = n.toCharArray();
        int len = arr.length;
        int left =  len / 2 - 1;
        int right = left + len % 2 + 1;
        for (int i = right; i < len; i++) {
            arr[i] = arr[left--];
        }
        return String.valueOf(arr);
    }
}
