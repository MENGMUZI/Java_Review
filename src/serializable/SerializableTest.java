package serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author : mengmuzi
 * create at:  2019-07-25  20:46
 * @description:  序列化和反序列化
 */
public class SerializableTest {

    /**
     * 序列化过程：将内存中的Java对象保存到磁盘中或者通过网络传输出去
     * 使用ObjectOutputStream
     */
    @Test
    public void testObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("我爱北京天安门！"));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));

            String str = (String) ois.readObject();
            System.out.println("反序列化的结果是：" + str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
