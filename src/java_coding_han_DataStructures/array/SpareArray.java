package java_coding_han_DataStructures.array;

/**
 * @author : mengmuzi
 * create at:  2019-07-25  00:56
 * @description: 棋盘问题=》稀疏数组和二维数组
 */
public class SpareArray {
    public static void main(String[] args) {
        //原始的二维数组11*11
        //0：没有棋子，1：黑子，2：蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //添加一个黑子
        chessArr[3][4] = 1;
        //输出原始数组
        System.out.println("输出原始数组：");
        for (int[] row  : chessArr) {
            for (int data  : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }


        //二维数组转稀疏数组
        //1.遍历整个数组得到非0数据的个数
        int sum = 0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr[i][j] != 0){
                    sum ++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组非0值存放到spareArr中
        int count = 0;//count 用于记录是第几个非 0 数据
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(chessArr[i][j] != 0){
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }

        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
            System.out.println();
        }
        System.out.println();




        //将稀疏数组 --》 恢复成 原始的二维数组
        /** 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的 chessArr2 = int
         *  2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
         *
         */

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr02[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i <sparseArr.length ; i++) {
            chessArr02[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr02) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
                System.out.println();
        }




    }












}
