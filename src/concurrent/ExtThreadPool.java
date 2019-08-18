package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  23:17
 * @description: 扩展线程池
 */
public class ExtThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行:" );
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 1; i <= 10 ; i++) {
            es.submit(()->{
                System.out.println(Thread.currentThread().getName() + "\t" + "thread is running!!!");
            });
            Thread.sleep(20);
        }
    }

}
