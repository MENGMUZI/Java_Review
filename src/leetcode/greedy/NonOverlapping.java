package leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : mengmuzi
 * create at:  2019-08-22  21:23
 * @description: 435. 无重叠区间
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 */
public class NonOverlapping {
    //方法一：动态规划
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        //先对其中元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        //memo[i] 表示以intervals【i】为结尾的区间能够构成最长不重叠的序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo,1);
        for (int i = 1; i < intervals.length ; i++) {
            for (int j = 0; j <i; j++) {
                if(intervals[i][0] >= intervals[j][1]){
                    memo[i] = Math.max(memo[i],1+memo[j]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < memo.length ; i++) {
            res = Math.max(0,memo[i]);
        }
        return intervals.length - res;

    }


    //贪心算法
    //按照区间的结尾排序
    //每次选择结尾最早结束的，且和当前区间不重叠的
    public int eraseOverlapIntervals02(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        //先对其中元素排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] != o2[1]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int res = 1;
        int pre = 0;
        for (int i = 1; i < intervals.length ; i++) {
            if(intervals[i][0] >= intervals[pre][1]){
                res ++;
                pre = i;
            }
        }
        return intervals.length - res;
    }

}
