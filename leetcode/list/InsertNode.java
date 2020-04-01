package list;

import java.util.List;

/**
 * 给定循环升序列表中的一个点，写一个函数向这个列表中插入一个新元素，使这个列表仍然是循环升序的。给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，你可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），你需要创建一个循环有序列表并返回这个点。否则。请返回原先给定的节点。
 *
 * 下面的例子可以帮你更好的理解这个问题：
 *
 *  
 *
 *
 *
 * 在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2。
 *
 *  
 *
 *
 *  
 *
 * 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3。
 *
 * 通过次数571提交次数1,931
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertNode {
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        //没有节点
        if (head == null) {
            Node curr = new Node(insertVal);
            curr.next = curr;
            return curr;
        }
        if (head.next == head) {
            Node curr = new Node(insertVal);
            curr.next = head;
            head.next = curr;
            return curr;
        }
        Node start = head;
        boolean insert = false;
        while (true) {

            //头尾节点的值相等
            if (start.val == start.next.val && start.next == head) {
                insert = true;
            }
            //后面的节点比较小
            if (start.val > start.next.val) {
                //如果是头结点直接插入
                if ((start.next == head)
                        //非头结点  而且小于后面的节点，说明是最小的值
                        || (start.next != head && start.next.val > insertVal)
                        //非头结点。且比当前的大，说明是最大的值
                        || (start.next.val < insertVal && insertVal > start.val)) {
                    insert = true;
                }

            }
            //后面的节点的值大于前面的,正常的case
            if (start.val <= insertVal && start.next.val >= insertVal) {
                insert = true;
            }
            if (insert) {
                Node curr = new Node(insertVal);
                curr.next = start.next;
                start.next = curr;
                break;
            }
            start = start.next;
        }
        return head;
    }
}
