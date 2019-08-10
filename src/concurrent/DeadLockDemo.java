package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  01:34
 * @description: ReentrantLock可以中断，死锁问题并中断解决死锁
 */
public class DeadLockDemo implements Runnable {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;
    public DeadLockDemo(int lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            if(lock == 1){
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "可以拿到lock1.......");
                TimeUnit.MILLISECONDS.sleep(2000);
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "可以拿到lock2.......");
            }else {
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "可以拿到lock2.......");
                TimeUnit.MILLISECONDS.sleep(2000);
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + "可以拿到lock1.......");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
                System.out.println(Thread.currentThread().getName() + "可以释放lock1.......");
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
                System.out.println(Thread.currentThread().getName() + "可以释放lock2.......");
            }
            System.out.println(Thread.currentThread().getName() + ":线程退出！！！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLockDemo deadLockDemo1 = new DeadLockDemo(1);
        DeadLockDemo deadLockDemo2 = new DeadLockDemo(2);
        Thread t1 = new Thread(deadLockDemo1,"t1");
        Thread t2 = new Thread(deadLockDemo2,"t2");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
    }
}
