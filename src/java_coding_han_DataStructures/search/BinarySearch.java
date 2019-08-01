package java_coding_han_DataStructures.search;

/**
 * @author : mengmuzi
 * create at:  2019-08-01  17:56
 * @description: 二分查找（使用二分查找的前提是 该数组是有序的）
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int resultIndex = binarySearch(arr,0,arr.length,-10);
        System.out.println(resultIndex);

    }

    // 二分查找算法

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
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
