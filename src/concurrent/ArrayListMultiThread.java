package concurrent;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author : mengmuzi
 * create at:  2019-08-10  16:06
 * @description: ArrayList并发下的问题
 */
public class ArrayListMultiThread {

    //static ArrayList<Integer> arrayList = new ArrayList<>();
    static Vector<Integer> arrayList = new Vector<>();
    //static CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    arrayList.add(j);
                }
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList);

    }


}
