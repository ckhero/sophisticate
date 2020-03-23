import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestContainer {
    List<Integer> list = new ArrayList<>();
    ReentrantLock lock  = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    boolean flag = false;
    int count = 0;
    public void t1() {
        lock.lock();
        try {
            while (count < 10) {
                while (flag) {
                    c1.await();
                }
                System.out.println(count);
                list.add(count++);
                if (list.size() == 5) {
                    flag = true;
                    c2.signal();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void t2(){
        lock.lock();
        try {
            System.out.println("t2 start");

            while (!flag) {
                c2.await();
            }
            System.out.println("t2");
            flag = false;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestContainer test = new TestContainer();
        new Thread(() -> {
            test.t1();
        }).start();
        new Thread(() -> {
            test.t2();
        }).start();
    }
}
