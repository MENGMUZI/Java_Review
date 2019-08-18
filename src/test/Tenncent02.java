package test;

import java.util.*;

/**
 * @author : mengmuzi
 * create at:  2019-08-17  20:40
 * @description:
 */
public class Tenncent02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();//数个数的次方
        int number = (int) Math.pow(2, num);//真正的几个数

        List<Integer> listNum01 = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            listNum01.add(scanner.nextInt());
        }
        int times = scanner.nextInt();//处理的次数
        int[] arrTime = new int[times];
        for (int i = 0; i < arrTime.length; i++) {
            arrTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < times; i++) {//进行的轮次
            List<Integer> inverseList = new ArrayList<>();
            List<Integer> listNum = new ArrayList<>();
            listNum = listNum01;
            int group = (int) Math.pow(2, arrTime[i]);//每一组的个数
            while(!listNum.isEmpty()){
                List<Integer> sublist = listNum.subList(0,group);
                Collections.reverse(sublist);
                for (int j = 0; j < sublist.size() ; j++) {
                    inverseList.add(sublist.get(j));
                }
                listNum = listNum.subList(group,listNum.size());
            }
            int[] inverseArr = new int[number];
            for (int j = 0; j <inverseList.size() ; j++) {
                inverseArr[j] = inverseList.get(j);
            }
            int reusult = inverseNumber(inverseArr);
            System.out.println(reusult);

        }

    }

    private static int inverseNumber(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int a = arr[i];
                int b = arr[j];
                if (a < b) {
                    count++;
                }
            }
        }
        return count;
    }

}
