package java_coding_han_DataStructures.sort;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-07-27  15:44
 * @description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};

//        //第一趟排序，就是将最大的数排在最后
//        int temp = 0;//临时变量
//        for (int i = 0; i < arr.length - 1; i++) {
//            //如果前面的数大于后面的数
//            if (arr[i] > arr[i + 1]) {
//                temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
//
//        System.out.println("第一趟排序后的数组：");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第二趟排序，就是将第二大的数排在倒数第二位
//        for (int j = 0; j < arr.length - 1 - 1; j++) {
//            // 如果前面的数比后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第二趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 第三趟排序，就是将第三大的数排在倒数第三位
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            // 如果前面的数比后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第三趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        // 第四趟排序，就是将第 4 大的数排在倒数第 4 位
//        for (int j = 0; j < arr.length - 1 - 3; j++) {
//            // 如果前面的数比后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第四趟排序后的数组");
//        System.out.println(Arrays.toString(arr));

//        System.out.println("=========================================================");

        System.out.println("冒泡排序排序后的数组");
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {//第几趟
            for (int j = 0; j < arr.length - 1 - i; j++) {//每趟交换的次数
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if(!flag){// 在一趟排序中，一次交换都没有发生过
                break;
            }else {
                flag = false; // 重置 flag!!!, 进行下次判断
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
