import java.util.concurrent.TimeUnit;

public class VolatileTest2 {
    private static class Test {
        int number = 0;
        private static Test instance = null;
        private Test(){
            System.out.println("gou");
        }

        // DCL double check lock
        static Test getInstance() {
            if (instance == null) {
                synchronized (Test.class) {
                    if (instance == null) {
                        instance = new Test();
                    }
                }
            }
            return instance;
        }
        void add(){
            this.number = 60;
        }
        void addPlus(){
            number++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            new Thread(()-> {
                for (int j = 0; j < 1000; j++) {
                    Test.getInstance();
                }
            }, "aaaa").start();
        }

//        TimeUnit.SECONDS.sleep(2);
//        System.out.println(aa.number);
    }
}
