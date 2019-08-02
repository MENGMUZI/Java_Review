package java_coding_han_DataStructures.search;

/**
 * @author : mengmuzi
 * create at:  2019-08-02  00:35
 * @description:  斐波那契查找
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8, 10, 89, 1000, 1234};
    }

    //因为后面我们 mid=low+F(k-1)-1，需要使用到斐波那契数列，因此我们需要先获取到一个斐波那契数列
    //非递归方法得到一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize ; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    public static void fibSearch(int[] a ,int key){
        int low = 0;
        int high = a.length -1 ;
        int k = 0; //表示斐波那契分割数值的下标
        int mid = 0; //存放 mid 值
        int f[] = fib(); //获取到斐波那契数列

    }


}
