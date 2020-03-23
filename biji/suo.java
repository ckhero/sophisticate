import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class suo {
    /**
     *1 公平锁 队列
     * 2。 非公平锁 可以抢锁  可能导致优先级反转 饥饿， 直接占用锁，占用失败公平锁  吞吐量大
     * 3。可重入锁 （递归锁） 外层获得锁，内层递归函数仍能获得该锁的代码  ReentrantLock/synchronized 非公平的可重入锁  防止死锁
     * 4。自旋锁  尝试获取锁的进程不会阻塞，而是采用循环的方式尝试获取该锁，好处是减少上下文的切换的消耗。缺点是消耗cpu
     * 5 独占锁（写锁）/共享锁（读锁）/互斥锁  读写锁 ReentrantReadWriteLock
     */

    public static void main(String[] args) {

        /**
         * 默认 非公平
         */

        ReentrantLock lock = new ReentrantLock();
    }
}
