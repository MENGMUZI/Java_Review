package reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : mengmuzi
 * create at:  2019-07-23  17:36
 * @description: 反射的复习
 */
public class ReflectionTest {

    @Test
    public void test01() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {
        //获取对象
        Class clazz = Person.class;

        //获取构造器
        Constructor constructor = clazz.getConstructor(String.class,int.class);
        Object obj = constructor.newInstance("cuihua",13);
        System.out.println(obj);

        //获取公有变量
        Field age = clazz.getDeclaredField("age");
        age.set(obj,20);
        System.out.println(obj);

        //获取方法
        Method method = clazz.getMethod("work");
        method.invoke(obj);

        //通过反射可以调用类的私有结构
        //私有构造器
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class,int.class,String.class);
        constructor1.setAccessible(true);
        Person person = (Person) constructor1.newInstance("如花",22,"女神");
        System.out.println(person);

        System.out.println("-------------------------------------------");
        Class clazz01 = Class.forName("reflect.Test01");
        System.out.println(clazz01);
        System.out.println(clazz01.getClassLoader());//sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(clazz01.getClassLoader().getParent());//sun.misc.Launcher$ExtClassLoader@6b884d57
        System.out.println(clazz01.getClassLoader().getParent().getParent());//获取不到引导类加载器
        System.out.println("----------------------------");




    }

}
