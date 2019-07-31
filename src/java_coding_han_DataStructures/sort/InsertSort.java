package java_coding_han_DataStructures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author : mengmuzi
 * create at:  2019-07-31  21:56
 * @description: 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1};
        //insertSort(arr);
        //insertSortAll(arr);

        // 创建要给 80000 个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);


        insertSortAll(arr); //调用插入排序算法


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);
        //System.out.println(Arrays.toString(arr));

    }


    //插入排序
    public static void insertSort(int[] arr) {
        //使用逐步推导的方式来讲解，便利理解
        //第 1 轮 {101, 34, 119, 1}; => {34, 101, 119, 1}
        //{101, 34, 119, 1}; => {101,101,119,1}
        // 定义待插入的数
        int insertVal = arr[1];
        int insertIndex = 1 - 1;//即 arr[1]的前面这个数的下标
        //给 insertVal 找到插入的位置
        //说明
        //1. insertIndex >= 0 保证在给 insertVal 找插入位置，不越界
        //2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
        //3. 就需要将 arr[insertIndex] 后移
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;

        }
        //当退出 while 循环时，说明插入的位置找到, insertIndex + 1
        arr[insertIndex + 1] = insertVal;
        System.out.println("第 1 轮插入");
        System.out.println(Arrays.toString(arr));


        //第2轮
        insertVal = arr[2];
        insertIndex = 2 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第 2 轮插入");
        System.out.println(Arrays.toString(arr));


        //第3轮
        insertVal = arr[3];
        insertIndex = 3 - 1;
        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex] insertIndex--;
            insertIndex--;
        }
        arr[insertIndex + 1] = insertVal;
        System.out.println("第 3 轮插入");
        System.out.println(Arrays.toString(arr));


    }


    //插入排序
    public static void insertSortAll(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
            //System.out.println("第" + i + "轮插入");
            //System.out.println(Arrays.toString(arr));
        }

    }


}
