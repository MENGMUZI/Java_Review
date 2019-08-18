package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author : mengmuzi
 * create at:  2019-08-18  14:45
 * @description:  CyclicBarrier召唤7龙珠
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(10,()->{
            System.out.println("召唤什么龙完成");
        });
        for (int i = 1; i <= 10 ; i++) {
            int finalI = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t收集到第"+ finalI +"颗龙珠");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }


    }

}
