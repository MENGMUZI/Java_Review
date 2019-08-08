package IO;

import org.junit.Test;

import java.io.*;

/**
 * @author : mengmuzi
 * create at:  2019-08-08  17:15
 * @description: 字节流
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStreamTest(){
        File file = new File("src/IO/hello.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!= -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileInputStreamFileOutputStream(){
        File srcFile = new File("src/IO/孟木子.jpeg");
        File desFile = new File("src/IO/孟木子01.jpeg");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);
            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!= -1){
                //String str = new String(buffer,0,len);
                //System.out.print(str);
                fos.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



}
