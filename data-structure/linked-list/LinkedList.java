import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2019/12/6
 * Time: 11:04 AM
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;
        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 大小
     */
    private int size;

    /**
     * 头节点
     */
    private Node dummyHead;

    /**
     * 初始化链表的时候 头部为空
     *
     */
    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size - 1;
    }

    /**
     * 是否是空链表
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index!");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i ++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i ++) {
            curr = curr.next;
        }
        return curr.e;
    }
}



