import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConditionTest {
    static class MyCache {
        private int num = 1;
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3= lock.newCondition();
        public void print5() throws InterruptedException {
            lock.lock();

            try {
                while (num != 1) {
                    c1.await();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("c1---" + i);
                }
                num = 2;
                c2.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print10() throws InterruptedException {
            lock.lock();

            try {
                while (num != 2) {
                    c1.await();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("c2---" + i);
                }
                num = 3;
                c3.signal();
            } finally {
                lock.unlock();
            }
        }

        public void print15() throws InterruptedException {
            lock.lock();

            try {
                while (num != 3) {
                    c1.await();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("c3---" + i);
                }
                num = 1;
                c1.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        MyCache mm = new MyCache();
        new Thread(() -> {
            try {
                mm.print5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                mm.print10();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                mm.print15();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
