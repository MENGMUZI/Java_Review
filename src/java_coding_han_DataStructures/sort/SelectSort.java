package java_coding_han_DataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : mengmuzi
 * create at:  2019-07-27  16:39
 * @description: 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1};

//        //第1轮
//        int minIndex = 0;
//        int min = arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (min > arr[i]) {
//                min = arr[i];
//                minIndex = i;
//            }
//        }
//
//        //将最小值，放在 arr[0], 即交换
//        if (minIndex != 0) {
//            arr[minIndex] = arr[0];
//            arr[0] = min;
//        }
//
//        System.out.println("第 1 轮后~~");
//        System.out.println(Arrays.toString(arr));

        //创建要给 80000 个的随机的数组， 在我的机器是 2-3 秒，比冒泡快.
        int[] arr02 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr02[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }


        System.out.println("排序前");
        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);
        selectSort(arr02);

        System.out.println("排序后");
        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str); //2秒

    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println("第" + (i + 1) + "轮后~~");
            //System.out.println(Arrays.toString(arr));
        }
       //System.out.println(Arrays.toString(arr));

    }
}
