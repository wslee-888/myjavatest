package com.liws.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

public class NIOUDPClientSocket {
    public static void main(String[] args) throws Exception{
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        datagramChannel.connect(new InetSocketAddress("192.168.1.191",8899));

        Selector readSelector = Selector.open();
        datagramChannel.register(readSelector,SelectionKey.OP_READ);

        Selector writeSelector = Selector.open();
        datagramChannel.register(writeSelector,SelectionKey.OP_WRITE);


        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);


        new Thread(){
            @Override
            public void run() {
                try {
                    while (true){
                        int num = readSelector.selectNow();

                        if (num <= 0){
                            continue;
                        }

                        Iterator<SelectionKey> it = readSelector.selectedKeys().iterator();
                        while (it.hasNext()){
                            SelectionKey selectionKey = it.next();

                            if (selectionKey.isReadable()){
                                datagramChannel.receive(readBuffer);

                                readBuffer.flip();

                                String str = new String(readBuffer.array(),0,readBuffer.limit());
                                if (str != null && !str.equals("")){
                                    System.out.println("客户端收到信息："+str);
                                }

                                readBuffer.clear();
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
                        int num = writeSelector.selectNow();

                        if (num <= 0){
                            continue;
                        }

                        Iterator<SelectionKey> it = writeSelector.selectedKeys().iterator();
                        while (it.hasNext()){
                            SelectionKey selectionKey = it.next();

                            if (selectionKey.isWritable()){
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                                String line = "";

                                while ((line = bufferedReader.readLine()) != null){
                                    writeBuffer.put(line.getBytes());
                                    writeBuffer.flip();

                                    datagramChannel.write(writeBuffer);

                                    writeBuffer.clear();
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
