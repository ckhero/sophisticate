import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    /**
     * jps -l
     */

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
//        MyDeadLock deadLock = new MyDeadLock(a,b);
//        MyDeadLock deadLock2 = new MyDeadLock(b,a);
//        deadLock.run();
//        deadLock2.run();

        new Thread(new MyDeadLock(a,b)).start();
        new Thread(new MyDeadLock(b,a)).start();
    }

    static class MyDeadLock implements Runnable {
        String a;
        String b;

        public MyDeadLock(String a, String b) {
            this.b = b;
            this.a = a;
        }

        @Override
        public void run() {
            synchronized (a) {
                System.out.println("try get " + a  + "--->" + b);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b) {
                    System.out.println("try get" + b + "--->" +a);

                }
            }
        }
    }
}
