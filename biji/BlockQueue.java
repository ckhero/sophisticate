import java.util.List;
import java.util.concurrent.*;

public class BlockQueue {
    /**
     * 1.阻塞队列的好处  --  无需关心什么时候阻塞队列 什么时候唤醒队列
     * 2。 不得不阻塞 如何管理
     */
    public static void main(String[] args) throws InterruptedException {
        List list = null;
        BlockingQueue blockList = new ArrayBlockingQueue<String>(3);
//        BlockingQueue list2 = new List
       // LinkedBlockingDeque  链表组成有界阻塞队列 无默认值
        //ArrayBlockingQueue 数据组成有界阻塞队列 有默认值
        //SynchronousQueue   不存储元素的阻塞队列，生产一个消费一个
//        SynchronousQueue

        blockList.add("aa");//不阻塞
        blockList.remove();//不阻塞   跑异常
        blockList.put("a");//阻塞
        blockList.take(); //阻塞
        blockList.offer("aaa", 2l, TimeUnit.SECONDS);//超时

//        SynchronousQueue sq = new Sync
    }
}
