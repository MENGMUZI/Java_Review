package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  01:58
 * @description: ReentrantLock中的锁限时等待，解决死锁问题，
 */
public class TimeLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try{
            if(lock.tryLock(2, TimeUnit.SECONDS)){
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "\t so lucky hold lock......");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t get lock failed...........");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        TimeLock timeLock = new TimeLock();
        Thread t1 = new Thread(timeLock,"t1");
        Thread t2 = new Thread(timeLock,"t2");
        t1.start();
        t2.start();
    }
}
