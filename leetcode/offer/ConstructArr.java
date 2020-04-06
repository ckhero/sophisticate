package offer;

/**
 * https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/
 * 面试题66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return a;
        }

        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = a[0];
        right[len - 1] = a[len - 1];
        int idx = 1;
        while (idx < len) {
            left[idx] = left[idx - 1] * a[idx];
            right[len - idx - 1] = right[len - idx] * a[len - idx - 1];
            idx++;
        }
        a[0] = right[1];
        a[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            a[i] = left[i - 1] * right[i + 1];
        }
        return a;
    }
}
