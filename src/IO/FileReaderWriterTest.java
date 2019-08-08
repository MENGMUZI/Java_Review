package IO;

import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author : mengmuzi
 * create at:  2019-08-08  16:21
 * @description: 字符流
 */

public class FileReaderWriterTest {
    @Test
    public void testFileReader() {
        File file = new File("src/IO/hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
//        int data = fr.read();
//        while(data != -1){
//            System.out.print((char) data);
//            data = fr.read();
//        }
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testFileReader01() {
        File file = new File("src/IO/hello.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            char[] cbuffer = new char[5];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {
//                for (int i = 0; i <len ; i++) {
//                    System.out.print(cbuffer[i]);
//                }
                String str = new String(cbuffer, 0, len);
                System.out.print(str);
            }
            fr.read(cbuffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileWriter() throws IOException {
        File file = new File("src/IO/hello01.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("Peter Steiner 说过，\"On the Internet, nobody knows you're a dog\"，\n" +
                "也就是说在互联网的另外一头，你都不知道甚至坐着一条狗。");
        fw.close();
    }


    @Test
    public void testFileReaderFileWriter() {
        File sfile = new File("src/IO/hello.txt");
        File cfile = new File("src/IO/hellocp.txt");

        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(sfile);
            fw = new FileWriter(cfile);

            char[] cbuffer = new char[1024];
            int len;
            while ((len = fr.read(cbuffer)) != -1) {
                fw.write(new String(cbuffer, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
