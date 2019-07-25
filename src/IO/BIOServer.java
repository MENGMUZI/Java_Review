package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : mengmuzi
 * create at:  2019-07-17  19:56
 * @description: 阻塞IO 服务端
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {

        byte[] buf = new byte[1024];

        ServerSocket serverSocket = new ServerSocket();

        serverSocket.bind(new InetSocketAddress(9999));

        System.out.println("BlockingIO Server is working....");

        while(true){

            //socket 专门负责通信
            System.out.println("waiting connection .......");
            Socket socket = serverSocket.accept();//阻塞（程序释放CPU资源）
            System.out.println("connection is OK .....");

            /*
            //单线程无法处理并发
            System.out.println("start waiting data .....");
            int read = socket.getInputStream().read(buf);//read阻塞
            System.out.println("end reading data..." + read);
            String context = new String(buf);
            System.out.println(context);
            */
            Thread thread = new Thread(new ExecuteSocket(socket));

            thread.start();

        }
    }

    //多线程，完成并发处理
    static class ExecuteSocket implements Runnable{
        byte[] buf = new byte[1024];
        Socket socket;
        //处理每个客户端的连接（读写）
        public ExecuteSocket(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                socket.getInputStream().read(buf);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String context = new String(buf);
            System.out.println(context);
        }
    }


}
