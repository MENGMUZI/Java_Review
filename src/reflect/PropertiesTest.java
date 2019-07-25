package reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : mengmuzi
 * create at:  2019-07-23  20:47
 * @description: Properties配置文件的读取
 */
public class PropertiesTest {

    @Test
    public void test01() throws IOException {
        Properties properties = new Properties();
        //读取配置资源的方式一: 使用输入流（文件位置默认是当前module下）
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);

        //读取资源的方式二: 使用ClassLoader(文件位置默认识别到当前module的src下)
        ClassLoader classLoader = PropertiesTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc02.properties");
        properties.load(is);


        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }



}
