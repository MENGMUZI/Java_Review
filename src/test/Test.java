package test;


public interface Test {

    int number = 0;

    public static int i = 1;

    public void test01();

    default int test02(){
        return (int) Math.random();
    }
}
