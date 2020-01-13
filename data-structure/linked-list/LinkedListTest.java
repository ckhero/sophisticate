import java.util.*;

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

        HashMap<Integer, Integer> aa = new HashMap<>();
        TreeMap<Integer, Integer> bb = new TreeMap<>();


        List<Integer> aaa = new ArrayList<>();
        aaa.add(1111);
        aaa.add(2222);
        for (Integer anAaa : aaa) {
            System.out.println(anAaa);
        }
        aa.put(1,1);
        aa.put(3,3);
        aa.put(2,2);

        bb.put(1,1);
        bb.put(3,3);
        bb.put(2,2);

        for (Integer integer : aa.keySet()) {
            System.out.println(integer);
        }

        for (Integer integer : bb.keySet()) {
            System.out.println(integer);
        }

    }
}

