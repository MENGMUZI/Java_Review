package concurrent;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  14:14
 * @description:
 */
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("this is myThread.........");
    }
}
public class NewThread {
    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Interrupted!!!");
                        break;
                    }
                    Thread.yield();
                }

            }
        };

        t1.start();
        Thread.sleep(2000);
        t1.interrupt();

    }



}
