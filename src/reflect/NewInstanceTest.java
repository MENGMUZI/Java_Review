package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : mengmuzi
 * create at:  2019-07-23  21:07
 * @description: 通过反射创建对应的运行时类的对象
 */
public class NewInstanceTest {

    @Test
    public void test01() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Class.forName("reflect.Person");

        //方法一：newInstance():调用此方法，创建对应的运行时类的对象
        Person obj = (Person) clazz.newInstance();
        System.out.println(obj);

        System.out.println("-------------------------------------------------");

        //方法二：
        Constructor constructor = clazz.getDeclaredConstructor(String.class,int.class);
        Person obj02 = (Person) constructor.newInstance("mengmuzi",23);
        System.out.println(obj02);


    }

}
