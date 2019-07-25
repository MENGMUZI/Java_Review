package reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : mengmuzi
 * create at:  2019-07-23  21:56
 * @description: 动态代理
 */
interface Human{
    String getBelief();

    void eat(String food);

}
//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eating everything............especially " + food);
    }
}

//AOP
class HumanUtil{
    public static void method01(){
        System.out.println("---------------common method 01 ------------");
    }

    public static void method02(){
        System.out.println("---------------common method 02 ------------");
    }


}
/**
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 *
 */
class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当我们调用代理类的对象，调用方法a时，就会自动的调用如下方法：invoke（）
    //将被代理类要执行的方法a的功能就声明在 invoke（）中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil.method01();
        //method:即为代理类对象调用的方法，此方法也就是作为被代理类对象要调用的方法
        Object result = method.invoke(obj,args);

        HumanUtil.method02();
        return result;
    }
}

class ProxyFactory{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(), handler);
    }
}
public class DynamicProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(proxyInstance);
        System.out.println(proxyInstance.getClass());//class reflect.$Proxy0
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("KFC");


        System.out.println("----------------------------");


        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory clothFactory  = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        clothFactory.produceCloth();
    }

}
