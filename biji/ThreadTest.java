import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadTest {
    /**
     * 1 thread new Thread
     * 2. 继承runable  无返回  run
     * 3。 继承cellable  有返回 抛异常 call
     *  线程状态  初始  执行 等待  阻塞 超时等待  结束
     */
    static class MyThread implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("a");
            return "aaa";
        }
    }
    public static void main(String[] args) throws Exception {
        FutureTask<String> BB = new FutureTask<>(new MyThread());
        new Thread(BB).start();
        System.out.println(BB.get());
    }
}
