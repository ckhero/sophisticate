import java.lang.reflect.Executable;
import java.util.concurrent.*;

public class ThreadPoll {
    /**
     * 优势
     *  1 降低资源消耗 通过重复利用已创建的线程降低线程创建和销毁的消耗
     *  2 提高响应速度  任务到达时不用等线程创建就能立即执行
     *  3 提高线程的可管性
     *  不是用线程池将会创建大量同类线程，导致内存消耗和过度切换
     *  线程池 操作类ThreadPoolExecutor
     *  Executors  带s的是辅助工具类
     *
     *  7大参数 核心线程数，最大线程数，空闲时间上限，单位，阻塞队列，创建工厂，拒绝策略
     *  工作原理啊
     *
     *  拒绝策略
     *  jdk 内置 策略
     *  1。默认 直接抛异常
     *  2。不会抛弃任务 也不会抛异常，而是将任务返回调用者
     *  3。 抛弃等待最久的任务，然后尝试
     *  4。直接丢任务
     *
     *  线程数配置
     *  cpu密集型  大量的计算  cpu核数 + 1
     *  io密集型  1。不是一直在执行 cpu * 2
     *           2。cpu /1-阻塞系数（0。8-0。9）
     */

    public static void main(String[] args) {
//        Executors.newFixedThreadPool()  执行长期的任务，固定数线程
//        Executors.newCachedThreadPool() 1> n
//        Executors.newSingleThreadExecutor()  一池一线程
//        Executors.newScheduledThreadPool()  调度任务
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//1池五线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//1池1线程
//        ExecutorService threadPool = Executors.newCachedThreadPool();//1池n线程
        ExecutorService threadPool = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 24; i++) {
                final int tmp = i;
                threadPool.execute(() -> {
//                    try {
////                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(Thread.currentThread().getName() + "处理了" + String.valueOf(tmp));
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            threadPool.shutdown();
        }
    }

    static class MyThreadPool {
        ExecutorService threaPool = new ThreadPoolExecutor(2, 5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    }
}
