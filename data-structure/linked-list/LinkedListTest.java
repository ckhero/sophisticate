/**
 * Created by IntelliJ IDEA.
 * User: ckhero
 * Date: 2019/12/6
 * Time: 11:54 AM
 */
public class LinkedListTest {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(2, 3);

        System.out.print(list.get(0));
        System.out.print(list.get(1));
        System.out.print(list.get(2));
        System.out.print(list.get(3));

    }
}

