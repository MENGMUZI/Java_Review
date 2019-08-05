package test;

import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-04  19:35
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        String resStr = maxSubstring(str1, str2);
        System.out.println(resStr);

    }

    //求解最长公共子串
    public static String maxSubstring(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return null;
        }
        if (str1.equals("") || str2.equals("")) {
            return null;
        }
        //二个子串中较长的一个子串
        String maxStr = "";
        //二个子串中较短的一个子串
        String minStr = "";
        if (str1.length() < str2.length()) {
            maxStr = str2;
            minStr = str1;
        } else {
            minStr = str2;
            maxStr = str1;
        }
        String current = "";
        for (int i = 0; i < minStr.length(); i++) {
            for (int begin = 0, end = minStr.length() - i; end <= minStr.length(); begin++, end++) {
                current = minStr.substring(begin, end);
                if (maxStr.contains(current)) {
                    return current;
                }
            }
        }
        return "";


    }

}
