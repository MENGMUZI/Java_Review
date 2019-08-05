package test;

/**
 * @author : mengmuzi
 * create at:  2019-08-06  02:08
 * @description:
 */
public class StrTest {

    public static void main(String[] args) {
        String str = "meng mu zi";
        System.out.println(str);
        System.out.println(str.toString());
        String str1 = str.replaceAll(" ","%%");
        String str2 = str.toString().replaceAll(" ","%%");
        System.out.println(str1);
        System.out.println(str2);

    }

}
