package leetcode.dynamic;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-22  22:58
 * @description:
 */
public class Fibonacci {
    //方法一
    private int num = 0;

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


    //方法二
    public int fib02(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
        return fib(N,memo);

    }

    public int fib(int N, int[] memo) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (memo[N] == -1) {
            memo[N] = fib(N - 1, memo) + fib(N - 2, memo);
        }
        return memo[N];
    }


}
