import java.util.concurrent.*;

/**
 * sync-lock 区别
 * 1。原始构成
 * sync 是关键字 jvm层次   monitor  wait notify； monitorenter  monitorexixt【推出两次 正常退出，异常退出】
 * lock 是java 类 api层面
 * 2。使用方法
 * sync 无需手动释放
 * lock 需要手动操作
 * 3。是否可中断
 * sync 不可中断
 * lock 可以中断
 * 4。加锁机制
 * sync 非公平
 * lock  公平非公平都行
 * 5 锁绑定多个条件
 * sync 无
 * lock  精确唤醒 （判断 -》 干活 -》 通知）
 */
public class CountDownTest
{
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        //防止虚假唤醒  判断用while
        //让一些线程阻塞 知道 一系列的线程完成后 再执行
        CyclicBarrier cyc = new CyclicBarrier(6, () -> {
            System.out.println("aaaaaa2222");

        });
        CountDownLatch count = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            final int tmp = i;
            new Thread(()-> {
                System.out.println(String.valueOf(tmp));
                try {
                    cyc.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                count.countDown();
            }).start();
        }
        count.await();
        System.out.println("aaaaaa");

        //并发资源控制,控制线程数
        Semaphore  se = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            final int tmp = i;
            new Thread(()-> {
                try {
                    se.acquire();
                    System.out.println(String.valueOf(tmp) + "start");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(String.valueOf(tmp) + "end");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    se.release();
                }
            }).start();
        }
    }
}
