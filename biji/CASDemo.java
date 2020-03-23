import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * arraylist  并发修改异常        java.util.ConcurrentModificationException
 * 缺点  循环 开销大
 *      只能对针对一个变量操作
 *
 *      引出 aba
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger aa = new AtomicInteger(10);
        aa.getAndIncrement();
    }
}
