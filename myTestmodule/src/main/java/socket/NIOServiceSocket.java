package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServiceSocket {

    public static void main(String[] args) throws Exception{

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.bind(new InetSocketAddress(8886));

        serverSocketChannel.configureBlocking(false);


        Selector acceptSelector = Selector.open();

        serverSocketChannel.register(acceptSelector, SelectionKey.OP_ACCEPT);

        Selector readSelector = Selector.open();

        Selector writeSelector = Selector.open();

       /* while (acceptSelector.select() > 0){

            Iterator<SelectionKey> it = acceptSelector.selectedKeys().iterator();

            while (it.hasNext()){
                SelectionKey sk = it.next();

                if (sk.isAcceptable()){

                    System.out.println(sk.toString()+":连接成功");

                    //serverSocketChannel = (ServerSocketChannel) sk.channel();

                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);

                    socketChannel.register(acceptSelector,SelectionKey.OP_READ | SelectionKey.OP_WRITE);

                }*//*else if (sk.isConnectable()){
                       System.out.println("连接状态");

                }*//*
                else if (sk.isReadable()){

                    System.out.println("读取状态");


                    SocketChannel socketChannel = (SocketChannel)sk.channel();

                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    int len;

                    while ((len = socketChannel.read(byteBuffer)) > 0){

                        byteBuffer.flip();

                        System.out.println(new String(byteBuffer.array(),byteBuffer.position(),byteBuffer.limit(),"utf-8"));
                    }

                }else if (sk.isWritable()){

                    //System.out.println("写入状态");

*//*                    SocketChannel socketChannel = (SocketChannel)sk.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                    String line = "";
                    while ((line = bufferedReader.readLine()) != null){

                        byteBuffer.put(line.getBytes());
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteBuffer.clear();
                    }*//*

                }

                it.remove();

            }
        }*/

        new Thread(){

            @Override
            public void run() {
                try {

                    while (true){
                        int acceptNum = acceptSelector.selectNow();

                        if (acceptNum <= 0){
                            continue;
                        }

                        Iterator<SelectionKey> it = acceptSelector.selectedKeys().iterator();

                        while (it.hasNext()){
                            SelectionKey sk = it.next();

                            if (sk.isAcceptable()){

                                System.out.println(sk.toString()+":连接成功");

                                //serverSocketChannel = (ServerSocketChannel) sk.channel();

                                SocketChannel socketChannel = serverSocketChannel.accept();

                                socketChannel.configureBlocking(false);

                                socketChannel.register(readSelector,SelectionKey.OP_READ);

                                socketChannel.register(writeSelector,SelectionKey.OP_WRITE);

                            }

                            it.remove();

                        }


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

                    while (true){

                        int readNum = readSelector.selectNow();

                        if (readNum <= 0){
                            continue;
                        }

                        Iterator<SelectionKey> it = readSelector.selectedKeys().iterator();

                        while (it.hasNext()){
                            SelectionKey sk = it.next();

                            if (sk.isReadable()){



                                SocketChannel socketChannel = (SocketChannel)sk.channel();

                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                                int len;

                                while ((len = socketChannel.read(byteBuffer)) > 0){
                                    System.out.println("读取状态");

                                    byteBuffer.flip();

                                    System.out.println(new String(byteBuffer.array(),byteBuffer.position(),byteBuffer.limit(),"utf-8"));
                                }

                            }

                            it.remove();

                        }
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

                    while (true){
                        int writeNum = writeSelector.selectNow();

                        if (writeNum <= 0){
                            continue;
                        }

                        Iterator<SelectionKey> it = writeSelector.selectedKeys().iterator();

                        while (it.hasNext()){
                            SelectionKey sk = it.next();

                            if (sk.isWritable()){



                                SocketChannel socketChannel = (SocketChannel)sk.channel();

                                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                                String line = "";
                                while ((line = bufferedReader.readLine()) != null){
                                    System.out.println("写入状态");
                                    byteBuffer.put(line.getBytes());
                                    byteBuffer.flip();
                                    socketChannel.write(byteBuffer);
                                    byteBuffer.clear();
                                }
                            }

                            it.remove();

                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
