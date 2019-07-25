package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : mengmuzi
 * create at:  2019-07-17  20:18
 * @description: 阻塞IO 客户端
 */
public class BIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();

        socket.connect(new InetSocketAddress("127.0.0.1",9999));

        Scanner scanner = new Scanner(System.in);

        System.out.println("BlockingIO Client is working....");

        System.out.println("please print in :");

        while(true){

            String next = scanner.next();

            socket.getOutputStream().write(next.getBytes());

        }

    }

}
