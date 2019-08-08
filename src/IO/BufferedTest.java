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

    @Test
    public void BufferedReaderBufferedWriterTest() throws IOException {
        File srcFile = new File("src/IO/hello.txt");
        File desFile = new File("src/IO/hello05.txt");

        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desFile));


        //方法一：使用char[] 数组
        char[] buffer = new char[1024];
        int len;
        while((len = br.read(buffer)) != -1){
            bw.write(buffer,0,len);
            bw.flush();
        }

        //方法二：使用String
        String data;
        while((data = br.readLine()) != null){
            bw.write(data);
        }

        br.close();
        bw.close();
    }

}
