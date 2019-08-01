package java_coding_han_DataStructures.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-01  15:44
 * @description: 桶排序--》基数排序
 */
public class RadixSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        //radixSort(arr);
        radixSort01(arr);


    }

    public static void radixSort(int[] arr) {
        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如:bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];

        //这里我们使用循环将代码处理


        //第 1 轮(针对每个元素的个位进行排序处理)
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        int index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到 arr
                    arr[index++] = bucket[k][l];
                    bucket[k][l] = 0;
                }
            }
            //第 l 轮处理后，需要将每个 bucketElementCounts[k] = 0 !!!!
            bucketElementCounts[k] = 0;

        }
        System.out.println("第 1 轮，对个位的排序处理 arr =" + Arrays.toString(arr));


        //第 2 轮(针对每个元素的十位进行排序处理)
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] / 10 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到 arr
                    arr[index++] = bucket[k][l];
                    bucket[k][l] = 0;
                }
            }
            //第 l 轮处理后，需要将每个 bucketElementCounts[k] = 0 !!!!
            bucketElementCounts[k] = 0;

        }
        System.out.println("第 2 轮，对个位的排序处理 arr =" + Arrays.toString(arr));

        //第 3 轮(针对每个元素的百位进行排序处理)
        for (int i = 0; i < arr.length; i++) {
            //取出每个元素的个位的值
            int digitOfElement = arr[i] / 100 % 10;
            //放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
            bucketElementCounts[digitOfElement]++;
        }

        //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
        index = 0;
        //遍历每一桶，并将桶中是数据，放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            //如果桶中，有数据，我们才放入到原数组
            if (bucketElementCounts[k] != 0) {
                //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    //取出元素放入到 arr
                    arr[index++] = bucket[k][l];
                    bucket[k][l] = 0;
                }
            }
            //第 l 轮处理后，需要将每个 bucketElementCounts[k] = 0 !!!!
            bucketElementCounts[k] = 0;

        }
        System.out.println("第 3 轮，对个位的排序处理 arr =" + Arrays.toString(arr));

    }

    public static void radixSort01(int[] arr) {
        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含 10 个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如:bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        //根据前面的推导过程，我们可以得到最终的基数排序代码
        //1. 得到数组中最大的数的位数

        int max = arr[0];   //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

            }
        }
        int maxLength = (String.valueOf(max).length());

        for (int h = 0, n = 1; h < maxLength; h++, n *= 10) {
            //第 1 轮(针对每个元素的个位进行排序处理)
            for (int i = 0; i < arr.length; i++) {
                //取出每个元素的个位的值
                int digitOfElement = arr[i] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                bucketElementCounts[digitOfElement]++;
            }

            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到 arr
                        arr[index++] = bucket[k][l];
                        bucket[k][l] = 0;
                    }
                }
                //第 l 轮处理后，需要将每个 bucketElementCounts[k] = 0 !!!!
                bucketElementCounts[k] = 0;

            }
            System.out.println("第"+(h+1)+"轮，对个位的排序处理 arr =" + Arrays.toString(arr));
        }


    }


}
