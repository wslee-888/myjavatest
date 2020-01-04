package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClientSocket {
    public static void main(String[] args) throws Exception{

/*        Channel channel;
        DatagramChannel datagramChannel;
        SocketChannel socketChannel;
        ServerSocketChannel serverSocketChannel;

        Selector selector;*/

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress(8886));

        //socketChannel.connect(new InetSocketAddress("192.168.1.191",8336));

        //socketChannel.connect(new InetSocketAddress(InetAddress.getByName("192.168.1.191"), 8336));


        //socketChannel.configureBlocking(false);
        ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        new Thread(){

            @Override
            public void run() {

                try {


                    String line = "";
                    System.out.println("开始写入");
                    while ((line = bufferedReader.readLine()) != null){
                        System.out.println("正在写入");
                        writeByteBuffer.put((line).getBytes());
                        writeByteBuffer.flip();
                        socketChannel.write(writeByteBuffer);
                        writeByteBuffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        new Thread(){
            @Override
            public void run() {
                try {
                    int len;
                    System.out.println("开始读取");
                    while ((len = socketChannel.read(readByteBuffer)) > 0){
                        System.out.println("正在读取");

                        readByteBuffer.flip();

                        System.out.println(new String(readByteBuffer.array(),readByteBuffer.position(),readByteBuffer.limit(),"utf-8"));
                    }

                    readByteBuffer.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
