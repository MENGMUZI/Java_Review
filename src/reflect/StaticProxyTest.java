package reflect;

/**
 * @author : mengmuzi
 * create at:  2019-07-23  21:39
 * @description: 静态代理
 */
interface ClothFactory{
    void produceCloth();
}

//代理类
class StaticProxyClothFactory implements ClothFactory {

    private ClothFactory factory;

    public StaticProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void produceCloth() {
        System.out.println("proxy factory will work....");
        factory.produceCloth();
        System.out.println("proxy factory is over.....");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike factory is working......");
    }
}
public class StaticProxyTest{

    public static void main(String[] args) {
        NikeClothFactory nike = new NikeClothFactory();

        StaticProxyClothFactory staticProxyClothFactory = new StaticProxyClothFactory(nike);

        staticProxyClothFactory.produceCloth();
    }

}

