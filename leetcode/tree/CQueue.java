package tree;

import java.util.LinkedList;

/**
 * 面试题09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 */
public class CQueue {
    LinkedList<Integer> a;
    LinkedList<Integer> b;
    public CQueue() {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
    }

    public void appendTail(int value) {
        a.add(value);
    }

    public int deleteHead() {
        if (b.isEmpty()) {

            if (a.isEmpty()) {
                return 0;
            }
            while (!a.isEmpty()) {
                b.add(a.removeLast());
            }
        }
        return b.removeLast();
    }

    /**
     * n - 1 最右边的1 变为0 ，最右边的1的右边 变为1
     * n & (n-1) 最右边的1变为0  其余不变
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans ++;
            n &= (n-1);
        }
        return ans;
    }


}
