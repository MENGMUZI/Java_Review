package java_coding_han_DataStructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : mengmuzi
 * create at:  2019-07-26  22:54
 * @description: 逆波兰计算器
 */
public class PolandNotation {

    public static void main(String[] args) {

        //先定义给逆波兰表达式
        //说明为了方便，逆波兰表达式 的数字和符号使用空格隔开
        //String suffixExpression = "3 4 + 5 * 6 -"; // 29
        //String suffixExpression = "30 4 + 5 * 6 -";//164
        //思路
        //1. 先将 "3 4 + 5 × 6-"=> 放到ArrayList中
        //2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈 完成计算

        //完成将一个中缀表达式转成后缀表达式的功能
        //1.1+((2+3)×4)-5=> 转成 123+4 × +5 –
        //2. 因为直接对 str 进行操作，不方便，因此 先将 "1+((2+3)×4)-5" =》 中缀的表达式对应的 List
        // 即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的 List => 后缀表达式对应的 List
        // 即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(suffixExpressionList);
        System.out.printf("expression=%d",calculate(suffixExpressionList));

//        List<String> rpnList = getListString(expression);
//        System.out.println(rpnList);
//        int res = calculate(rpnList);
//        System.out.println("计算的结果是= " + res);




    }

    //将一个逆波兰表达式， 依次将数据和运算符 放入到 ArrayList 中
    public static List<String> getListString(String suffixExpression){
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for(String element : split){
            list.add(element);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    /*
     * 1)从左至右扫描，将 3 和 4 压入堆栈;
     * 2)遇到+运算符，因此弹出 4 和 3(4 为栈顶元素，3 为次顶元素)，计算出 3+4 的值，得 7，再将 7 入栈;
     * 3)将 5 入栈;
     * 4)接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈;
     * 5)将 6 入栈;
     * 6)最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
     */
    public static int calculate(List<String> list){
        Stack<String> stack = new Stack<>();
        for(String element : list){
            if(element.matches("\\d+")){
                stack.push(element);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());

                int res = 0;
                if (element.equals("+")) {
                    res = num1 + num2;
                } else if (element.equals("-")) {
                    res = num1 - num2;
                } else if (element.equals("*")) {
                    res = num1 * num2;
                } else if (element.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把 res 入栈
                stack.push("" + res);
            }

        }
        return Integer.parseInt(stack.pop());
    }


    //方法:将 中缀表达式转成对应的 List
    // s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s){
        //定义一个 List,存放中缀表达式 对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0; //这时是一个指针，用于遍历 中缀表达式字符串
        String str; // 对多位数的拼接
        char c; // 每遍历到一个字符，就放入到 c
        while (i < s.length()){
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57){
                ls.add("" + c );
                i ++;
            }else{
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >=48 && (c = s.charAt(i)) <= 57){
                    str += c;
                    i ++;
                }
                ls.add(str);
            }
        }
        return ls;


    }


    //即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =》 ArrayList [1,2,3,+,4,*,+,5,–]
    // 方法:将得到的中缀表达式对应的 List => 后缀表达式对应的 List
    public static List<String> parseSuffixExpressionList(List<String> ls){

        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //说明:因为 s2 这个栈，在整个转换过程中，没有 pop 操作，而且后面我们还需要逆序输出
        // 因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈 s2
        List<String> s2 = new ArrayList<String>(); // 储存中间结果的 Lists2

        //遍历 ls
        for(String item: ls) {
            //如果是一个数，加入 s2
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if(item.equals("(")){
                s1.push(item);
            } else if(item.equals(")")){
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();

            } else {
                //当 item 的优先级小于等于 s1 栈顶运算符, 将 s1 栈顶的运算符弹出并加入到 s2 中，再次转到(4.1) 与 s1 中新的栈顶运算符相比较
                //问题:我们缺少一个比较优先级高低的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将 s1 中剩余的运算符依次弹出并加入 s2
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;

    }

}
//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }
}
