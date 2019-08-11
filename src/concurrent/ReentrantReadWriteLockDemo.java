package concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  23:25
 * @description: 读写锁ReentrantReadWriteLock
 *   能保证读写、写读和写写的过程是互斥的时候是独享的，读读的时候是共享的。
 */
class MyResource{
    private volatile Map<String,Object> map = new HashMap<>();

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        reentrantReadWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
        //模拟网络拥堵
        try{
            TimeUnit.MILLISECONDS.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        map.put(key,value);
        System.out.println(Thread.currentThread().getName() + "\t 写入完成：" );
        reentrantReadWriteLock.writeLock().unlock();
    }

    public void get(String key){
        reentrantReadWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "\t 正在读取：" );
        //模拟网络拥堵
        try{
            TimeUnit.MILLISECONDS.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        reentrantReadWriteLock.readLock().unlock();
    }
    public void clearMap(){
        map.clear();
    }
}
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource();
        for (int i = 1; i <= 10 ; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.put(String.valueOf(finalI),String.valueOf(finalI));
            },String.valueOf(i)).start();
        }

        for (int i = 1; i <= 10 ; i++) {
            int finalI = i;
            new Thread(()->{
                myResource.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }

    }


}
