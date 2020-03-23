import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ArrayListTest {
    /**
     *  * arraylist  并发修改异常        java.util.ConcurrentModificationException
     *  1         new Vector<>()
     *  2.        Collections.synchronizedList(new ArrayList<>())
     *  3.        new CopyOnWriteArrayList<>(); 写时复制
     *
     *  原因
     *  并发修改导致
     *  复制原容器，添加元素 再将原容器的引用指向新容器，并发读 不需要加锁 ，读写分离
     */

    public static void main(String[] args) {

       List<String> aa = new CopyOnWriteArrayList<>();
       aa.add("a");

       //继承 CopyOnWriteArrayList
        Set<String> aaa = new CopyOnWriteArraySet<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("a","a");
        aaa.add("aa");


    }
}
