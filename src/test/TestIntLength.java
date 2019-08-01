package test;

import org.junit.Test;

/**
 * @author : mengmuzi
 * create at:  2019-08-01  17:33
 * @description:
 */
public class TestIntLength {
    @Test
    public void test01(){
        int max = 12313134;
        int maxLength = (String.valueOf(max).length());
        System.out.println(maxLength);

    }

}
