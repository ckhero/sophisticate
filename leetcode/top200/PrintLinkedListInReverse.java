package top200;

/**
 * https://leetcode-cn.com/problems/print-immutable-linked-list-in-reverse/
 * 1265. 逆序打印不可变链表
 * 给您一个不可变的链表，使用下列接口逆序打印每个节点的值：
 *
 * ImmutableListNode: 描述不可变链表的接口，链表的头节点已给出。
 * 您需要使用以下函数来访问此链表（您 不能 直接访问 ImmutableListNode）：
 *
 * ImmutableListNode.printValue()：打印当前节点的值。
 * ImmutableListNode.getNext()：返回下一个节点。
 * 输入只用来内部初始化链表。您不可以通过修改链表解决问题。也就是说，您只能通过上述 API 来操作链表。
 *
 *
 *
 * 进阶：
 *
 * 您是否可以：
 *
 * 使用常数级空间复杂度解决问题？
 * 使用线性级时间复杂度和低于线性级空间复杂度解决问题？
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[4,3,2,1]
 * 示例 2：
 *
 * 输入：head = [0,-4,-1,3,-5]
 * 输出：[-5,3,-1,-4,0]
 * 示例 3：
 */
public class PrintLinkedListInReverse {
      interface ImmutableListNode {
      public void printValue(); // print the value of this node.
      public ImmutableListNode getNext(); // return the next node.
  };
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }
}
