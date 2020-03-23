package zijie;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);

        System.out.println(cache.get(2));
        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));        // 返回 -1 (未找到)
//        System.out.println(cache.get(3));        // 返回  3
//        System.out.println(cache.get(4));
    }


//    private class ListNode {
//        int key;
//        int val;
//        ListNode next;
//        ListNode(int key, int val) { this.key = key; this.val = val; }
//    }
//    ListNode list = new ListNode(-1, -1);
    private int capacity;
//    private int size = 0;
//
    public LRUCache(int capacity) {
       super(capacity,0.75F, true);
       this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

