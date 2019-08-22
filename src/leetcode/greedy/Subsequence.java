package leetcode.greedy;

/**
 * @author : mengmuzi
 * create at:  2019-08-22  20:46
 * @description: 392. 判断子序列
 * 时间复杂度0（n）
 */
public class Subsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex <= s.length() && tIndex <= t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();


    }

    public boolean isSubsequence02(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int index = -1;
        for(char element : s.toCharArray()){
            index = t.indexOf(element,index + 1);
            if(index == -1){
                return false;
            }
        }

        return true;

    }

}
