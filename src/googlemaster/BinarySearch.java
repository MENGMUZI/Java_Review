package googlemaster;

/**
 * @author : mengmuzi
 * create at:  2019-08-14  21:42
 * @description: 二分查找
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;
        //loop invariant: [a,b) is a valid range (a <= b)
        // k may only be in array [a,b)
        while (a < b) {
            int m = a + ((b - a) >> 1);
            // a == b : m =a;
            // b == a+1 : m =a;
            // b == a+2 : m = a+1;
            if (k < arr[m]) {//[a,b)+[b,c)=[a,c)  b -a = len([a,b)) [a,a)=> arr.isEmpty()
                b = m;
            } else if (k > arr[m]) {
                a = m + 1;
            } else {
                return m;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(new int[]{1, 2, 10, 15, 20, 25}, 10));
    }

}
