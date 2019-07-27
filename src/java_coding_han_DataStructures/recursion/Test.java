package java_coding_han_DataStructures.recursion;

/**
 * @author : mengmuzi
 * create at:  2019-07-27  10:55
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        test(4);
        int result = factorial(4);
        System.out.println(result);
    }

    public static void test(int n){
        if(n > 2){
            test(n - 1);

        }
        System.out.println("n =" + n);
    }

    public static int factorial(int n){
        if(n == 1){
            return 1;
        }else{
            return factorial(n - 1) * n;
        }
    }
}
