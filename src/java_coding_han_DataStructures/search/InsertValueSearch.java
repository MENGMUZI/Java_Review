package java_coding_han_DataStructures.search;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-01  23:56
 * @description: 插值查找
 * 1) 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
 * 2) 关键字分布不均匀的情况下，该方法不一定比折半查找要好
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        int index = insertValueSearch(arr, 0, arr.length - 1, 19);
        System.out.println("index:" + index);

        int bindex = binarySearch(arr, 0, arr.length - 1, 19);
        System.out.println("bindex:" + bindex);

    }

    //编写插值查找算法 
    //说明:插值查找算法，也要求数组是有序的 

    /**
     * @param arr     数组
     * @param left    左边索引
     * @param right   右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        int count = 0;
        System.out.println("insertValueSearch被调用" + (++count) + "次");
        //注意:findVal < arr[0] 和 findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        // 求出 mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    //二分查找与插值查找的对比
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int count = 0;
        System.out.println("binarySearch被调用" + (++count) + "次");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (midVal < findVal) {//向右递归
            return binarySearch(arr, mid + 1, right, findVal);

        } else if (midVal > findVal) {//向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

}
