package test;

import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-16  19:04
 * @description:
 */
public class Test0202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.length() == 0){
            System.out.println("-1");
            return;
        }
        String subStr = str.substring(1, str.length() - 1);
        if(subStr.length() == 0){
            System.out.println("-1");
            return;
        }
        String[] arr = subStr.split(",");

        int[] arrInt = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrInt[i] = Integer.parseInt(arr[i]);
        }
        int index = binarySearch(arrInt, 0, arrInt.length, 19);
        System.out.println(index+1);

    }

    private static int binarySearch(int[] arr, int start, int end, int target) {
        if (start >= end) {
            return -2;
        }
        int mid = start + ((end - start) >> 1);
        if (target == arr[mid]) {
            return mid;
        } else if (target > arr[mid]) {
            return binarySearch(arr, mid + 1, end, target);

        } else {
            return binarySearch(arr, start, mid - 1, target);
        }
    }

}
