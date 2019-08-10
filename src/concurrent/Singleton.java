package concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  22:03
 * @description: 单例模式
 */
public class Singleton {
    //private static Singleton instance = null;
    private static volatile Singleton instance = null;

    private Singleton(){
        System.out.println(Thread.currentThread().getName() + "construction....");
    }

    public static Singleton getInstance(){
        if(instance == null){
            //instance = new Singleton();
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10 ; i++) {
            executorService.execute(()->{
                Singleton.getInstance();
            });
        }
        executorService.shutdown();
    }

}
