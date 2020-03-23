import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {

    private int flag = 1;
    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            flag = 2;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag = 3;
            c2.signal();
        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {



        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag = 1;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }
}