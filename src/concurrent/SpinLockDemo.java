package concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  14:18
 * @description: 实现一个自旋锁
 */
class MySpinLock{
    public static AtomicReference<Thread> atomicReference = new AtomicReference<>();
    public void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + "\t come in o(n_n)o");
        while(!atomicReference.compareAndSet(null,thread)){
            //loop
        }
    }
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName() + "\t invoke myUnlock()");
    }

}
public class SpinLockDemo {
    public static void main(String[] args) {
        MySpinLock mySpinLock = new MySpinLock();
        new Thread(()->{
            mySpinLock.myLock();
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mySpinLock.myUnLock();
        },"t1").start();

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            mySpinLock.myUnLock();
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

    }


}
