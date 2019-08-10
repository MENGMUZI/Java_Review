package concurrent;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  15:25
 * @description: 守护线程
 */
public class Daemon {

    public static void main(String[] args) throws InterruptedException {
        Thread deemonT = new Thread(){
            @Override
            public void run(){
                while (true){
                    System.out.println("I am alive!!!");
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        deemonT.setDaemon(true);
        deemonT.start();

        Thread.sleep(2000);
    }

}
