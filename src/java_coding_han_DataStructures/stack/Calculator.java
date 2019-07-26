package java_coding_han_DataStructures.stack;

/**
 * @author : mengmuzi
 * create at:  2019-07-26  16:02
 * @description: 实现计算器
 */
public class Calculator {
    public static void main(String[] args) {
        //String expression = "3+2*6-2";
        //String expression = "17+2*6-4";
        //String expression = "7*2*2-5+1-5+3-4";
        String expression = "7*2+4/2+1-2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum ="";

        //开始 while 循环的扫描 expression
        while (true){
            //依次得到 expression 的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        operStack.push(ch);
                    }else {
                        operStack.push(ch);
                    }

                }else{
                    operStack.push(ch);
                }
            }else {
                //如果是数，则直接入数栈
                //numStack.push(ch -48);//? "1+3" '1' => 1
                //分析思路
                //1. 当处理多位数时，不能发现是一个数就立即入栈，因为他可能是多位数
                //2. 在处理数，需要向 expression 的表达式的 index 后再看一位,如果是数就进行扫描，如果是符号才入栈
                //3. 因此我们需要定义一个变量 字符串，用于拼接 //处理多位数
                //处理多位数
                keepNum += ch;

                //如果 ch 已经是 expression 的最后一位，就直接入栈
                if(index == expression.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else{
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index ++;
            if(index >= expression.length()){
                break;
            }
        }


        //当表达式扫描完毕，就顺序的从 数栈和符号栈中 pop 出相应的数和符号，并运行.
        while (true){
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if(operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        int result = numStack.pop();
        System.out.printf("表达式 %s = %d", expression, result);


    }

}

//先创建一个栈,直接使用前面创建好
//定义一个 ArrayStack2 表示栈, 需要扩展功能
class ArrayStack2{
    private int maxSize;//栈的大小

    private int[] stack;//数组，数组模拟栈，数据就放在该数组

    private int top = -1;// top 表示栈顶，初始化为-1

    //构造器
    public ArrayStack2(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //返回栈顶的值
    public int peek(){
        return stack[top];

    }
    //栈满
    public boolean isFull(){
        return top == maxSize -1;
    }

    //栈空
    public boolean isEmpty(){
        return top == -1;

    }

    //入栈-push
    public void push(int value){
        //先判断栈是否满
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top ++;
        stack[top] = value;

    }


    //出栈-pop, 将栈顶的数据返回
    public int pop(){
        //先判断栈是否空
        if(isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top --;
        return value;
    }

    //显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有数据~~");
            return;
        }
        for(int i = top ; i > 0 ;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示
    //数字越大，则优先级就越高.
    public int priority(int oper){
        if(oper == '*' || oper == '/'){
            return 1;
        }else if(oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val =='*' || val =='/';
    }

    //计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }


}


