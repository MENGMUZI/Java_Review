package concurrent;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  15:32
 * @description: 优先级
 */
public class PriorityDemo {

    public static void main(String[] args) {
        Thread hightPriority = new Thread() {
            int count = 0;
            @Override
            public void run(){
                while(true){
                    synchronized (PriorityDemo.class){
                        count++;
                        if(count > 10000000){
                            System.out.println("hightPriority is ok !!!!");
                            break;
                        }
                    }
                }
            }

        };

        Thread lowPriority = new Thread() {
            int count = 0;
            @Override
            public void run(){
                while(true){
                    synchronized (PriorityDemo.class){
                        count++;
                        if(count > 10000000){
                            System.out.println("lowPriority is ok !!!!");
                            break;
                        }
                    }
                }
            }

        };

        hightPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);


        lowPriority.start();
        hightPriority.start();

    }

}
