package zijie;

import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node/
 * https://leetcode-cn.com/problems/linked-list-random-node/solution/xu-shui-chi-chou-yang-suan-fa-by-jackwener/
 * 382. 链表随机节点
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 *
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * 示例:
 *
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * 通过次数4,455提交次数7,921
 */
public class RadomNode {
    public static void main(String[] args) {
        Random r = (new Random());
        for (int i = 2; i < 4; i++) {
            System.out.println(r.nextInt(i));
        }
    }
 public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */

    public RadomNode(ListNode head) {
        this.head = head;
    }
    private ListNode head;
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        int curr = -1;
        ListNode end = head;
        Random r = (new Random());

        while (end != null) {
            int tmp = r.nextInt(count) + 1;
            if (tmp == count) {
                curr = end.val;
            }
            count++;
            end = end.next;
        }
        return curr;
    }
}
