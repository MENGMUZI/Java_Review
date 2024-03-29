package java_coding_han_DataStructures.recursion;

/**
 * @author : mengmuzi
 * create at:  2019-07-27  12:59
 * @description: 八皇后问题
 */
public class Queue8 {

    //定义一个 max 表示共有多少个皇后
    int max = 8;

    //定义数组 array, 保存皇后放置位置的结果,比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];

    static int count = 0;

    static int judgeCount = 0;

    public static void main(String[] args) {
        //测试一把 ， 8 皇后是否正确
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d 解法", count);
        System.out.printf("一共判断冲突的次数%d 次", judgeCount); // 1.5w
    }

    //编写一个方法，放置第 n 个皇后
    //特别注意: check 是 每一次递归时，进入到 check 中都有 for(int i = 0; i < max; i++)，因此会有回溯
    public void check(int n){
        if(n == max){
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max ; i++) {
            //先把当前这个皇后 n , 放到该行的第 i 列
            array[n] = i;
            //判断当放置第 n 个皇后到 i 列时，是否冲突
            if(judge(n)){
                check(n + 1);
            }
            //如果冲突，就继续执行 array[n] = i; 即将第 n 个皇后，放置在本行得 后移的一个位置
        }
    }

    //查看当我们放置第 n 个皇后, 就去检测该皇后是否和前面已经摆放的皇后冲突
    /**
     * @param n 表示第 n 个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n ; i++) {
            // 说明
            //1. array[i] == array[n]
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第 n 个皇后是否和第 i 皇后是否在同一斜线上
            //n=1 放置第 2列 1n=1array[1]=1
            // Math.abs(1-0) == 1 Math.abs(array[n] - array[i]) = Math.abs(1-0) = 1 //3. 判断是否在同一行, 没有必要，n 每次都在递增
            if(array[i] == array[n] || Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }

        }
        return true;

    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
