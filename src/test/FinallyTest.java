package test;

/**
 * @author : mengmuzi
 * create at:  2019-08-09  10:28
 * @description:
 */
public class FinallyTest {

    public static void main(String[] args) {
        int result = finallyTest();
        System.out.println(result);
    }

    public static int finallyTest(){
        int number = 20;
        try{
            System.out.println("try block......");
            number = number + 80;
            return number;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("finally block.......");
            if(number > 20){
                System.out.println(number);
            }
            return 1;
            //number --;
        }
    }
}
