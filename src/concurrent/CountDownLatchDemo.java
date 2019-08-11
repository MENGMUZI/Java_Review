package concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-08-11  23:49
 * @description: CountDownLatch的用法
 */
public class CountDownLatchDemo {
    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上晚自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t***********班长关门走人！！！！！");
    }

    public static void fireRocket() throws InterruptedException {
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(15);
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        for (int i = 1; i <= 15; i++) {
            executorService.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(new Random().nextInt(15) * 1000);
                    System.out.println(Thread.currentThread().getName() + "\t\t check completed!!!!!!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.printf("检查完所有工序的时间为 %d 秒", (end - start) / 1000);
        System.out.println();
        System.out.println("Fire!!!!!!!!!!!!!");
        executorService.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        //closeDoor();//演示班长锁门
        fireRocket();//演示火箭发射
    }

}
