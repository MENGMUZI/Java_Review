package leetcode.greedy;

import java.util.Arrays;

/**
 * @author : mengmuzi
 * create at:  2019-08-22  20:24
 * @description: 455. Assign Cookies
 *  https://leetcode.com/problems/assign-cookies/description/
 *  先尝试满足最贪心的小朋友
 *  时间复杂度: O(nlogn)
 *  空间复杂度: O(1)
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);//胃口值
        Arrays.sort(s);//蛋糕的大小

        int gi = g.length -1, si = s.length -1;
        int result = 0;
        while(gi >= 0 && si >= 0){
            if(g[gi] <= s[si]){
                result++;
                si --;
            }
            gi --;
        }
        return result;
    }

    public static void main(String[] args) {
        int g[] = {1,2};
        int s[] = {1,2,3};
        System.out.println(new AssignCookies().findContentChildren(g,s));
    }

}
