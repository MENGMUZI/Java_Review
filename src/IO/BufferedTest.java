package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author : mengmuzi
 * create at:  2019-08-08  17:39
 * @description: 缓冲流的使用
 */
public class BufferedTest {

    @Test
    public void BufferedStreamTest() throws IOException {
        File srcFile = new File("src/IO/孟木子.jpeg");
        File desFile = new File("src/IO/孟木子的副本.jpeg");

        //节点流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            //缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer))!= -1){
                bos.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            fos.close();
        }



    }

}
