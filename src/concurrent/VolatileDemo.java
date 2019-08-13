package concurrent;

import sun.misc.Unsafe;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  13:15
 * @description:  volatile可见性的证明
 */

class MyData {
    volatile int number = 0;

    public void addT060() {
        this.number = 60;
    }

    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }

}


public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData01 = new MyData();
        MyData myData02 = new MyData();


//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName() + "\t come in");
//            try{
//                TimeUnit.MILLISECONDS.sleep(300);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            myData.addT060();
//            System.out.println(Thread.currentThread().getName() + "\t updated number value: " + myData.number);
//        },"AAA").start();
//
//        while (myData.number == 0){
//
//        }
//        System.out.println(Thread.currentThread().getName() + "\t mission is over ，main get the number value :"  + myData.number);

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 10000; j++) {
                    myData01.addPlusPlus();
                    myData02.addMyAtomic();

                }
            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value :" + myData01.number);
        System.out.println(Thread.currentThread().getName() + "\t finally number value :" + myData02.atomicInteger);

    }

}
