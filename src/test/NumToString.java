package test;

import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-08-06  20:03
 * @description: 阿拉伯数字中文读法
 */
public class NumToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String[] unitStrings={"","十","百","千","万","十","百","千","亿","十"};
        String[] num={"零","一","二","三","四","五","六","七","八","九"};
        StringBuilder rst=new StringBuilder();
        int len= s.length();
        int index= s.length()-1;
        while(index>=0){
            int curNum=Integer.valueOf(s.charAt(index)+"");
            if(curNum!=0){
                rst.insert(0, unitStrings[len-index-1]);
                rst.insert(0, num[curNum]);
            }else {
                if(rst.length()!=0&&rst.charAt(0)!='零'&&rst.charAt(0)!='万'&&rst.charAt(0)!='亿'){
                    rst.insert(0, num[curNum]);
                }
                if(unitStrings[len-index-1].equals("万")||unitStrings[len-index-1].equals("亿")){
                    rst.insert(0, unitStrings[len-index-1]);
                }
            }
            index--;
        }
        System.out.println(rst.toString());
    }


}
