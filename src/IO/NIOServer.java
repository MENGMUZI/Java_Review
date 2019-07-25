package IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : mengmuzi
 * create at:  2019-07-17  21:12
 * @description: 非阻塞IO 服务器端
 */
public class NIOServer {

    public static void main(String[] args) {
        List<SocketChannel> list = new ArrayList<>();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();

            ssc.bind(new InetSocketAddress(8888));

            ssc.configureBlocking(false);//设置为非阻塞

            while (true){
                Selector selector = Selector.open();

                SocketChannel socketChannel = ssc.accept();

                if(socketChannel == null){
                    Thread.sleep(1000);
                    System.out.println("没有人连接");

                    for(SocketChannel channel : list){
                        int len = channel.read(byteBuffer);
                        System.out.println(len);
                        if(len != 0){
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array()));
                        }
                    }
                }else {
                    socketChannel.configureBlocking(false);
                    list.add(socketChannel);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
