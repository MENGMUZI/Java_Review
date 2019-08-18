package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-08-17  20:00
 * @description:
 */
public class Tencent01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //数栈
        Stack<String> strStack = new Stack<>();
        //字符串的栈
        int i = 0;
        Stack<String> numStack = new Stack<>();
        StringBuffer curString = new StringBuffer();
        while(i < s.length()){
            char curC = s.charAt(i);
            if(curC == '['){
                if(curString.length() != 0){
                    strStack.add(curString.toString());
                    curString = new StringBuffer();
                }
                StringBuffer curNum = new StringBuffer();
                i++;
                while(i < s.length() && s.charAt(i) != '|'){
                    curNum.append(s.charAt(i));
                    i++;
                }
                numStack.add(curNum.toString());
            }
            else if(curC == '|'){
                StringBuffer curStr = new StringBuffer();
                i++;
                while (i < s.length() && (s.charAt(i) != '[' && s.charAt(i) != ']')){
                    curStr.append(s.charAt(i));
                    i++;
                }
                strStack.add(curStr.toString());
            }
            else if(curC == ']'){
                int num = Integer.parseInt(numStack.pop());
                String str = strStack.pop();
                StringBuffer ts = new StringBuffer();
                for (int j = 0; j < num ; j++) {
                    ts.append(str);
                }
                if(!strStack.isEmpty()){
                    String pre = strStack.pop();
                    strStack.add(pre + ts.toString());
                }else{
                    strStack.add(ts.toString());
                }
                i++;
            }
            else{
                curString.append(curC);
                i++;
            }

        }
        if(curString.length() != 0){
            strStack.add(curString.toString());
        }
        StringBuffer ans = new StringBuffer();
        for (String t : strStack) {
            ans.append(t);
        }
        System.out.println(ans.toString());
    }

}
