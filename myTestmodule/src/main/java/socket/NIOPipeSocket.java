package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class NIOPipeSocket {
    public static void main(String[] args) throws Exception{
        Pipe pipe = Pipe.open();

        Pipe.SinkChannel sink = pipe.sink();

        Pipe.SourceChannel source = pipe.source();


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ByteBuffer readByteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024);

        new Thread(){
            @Override
            public void run() {

                try {
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null){
                        writeByteBuffer.put(line.getBytes());
                        writeByteBuffer.flip();

                        sink.write(writeByteBuffer);

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
                    while ((len = source.read(readByteBuffer)) > 0){
                        readByteBuffer.flip();
                        System.out.println("收到管道信息："+new String(readByteBuffer.array(),0,readByteBuffer.limit()));
                        readByteBuffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }.start();
    }
}
