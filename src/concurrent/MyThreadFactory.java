package concurrent;

import java.util.concurrent.*;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  22:33
 * @description: 自定义线程工厂
 */
public class MyThreadFactory {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5,
                10,
                0L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setDaemon(true);
                        System.out.println("create daemon" + thread);
                        return thread;
                    }
                });
        for (int i = 1; i <= 10 ; i++) {
            es.submit(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + "thread is running!!!");
            });
        }

        Thread.sleep(2000);

    }

}
