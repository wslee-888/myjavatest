package socket;

import java.io.*;
import java.net.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class MyClientSocketThread implements Runnable{
    private Socket socket;

    public MyClientSocketThread() {
    }

    public MyClientSocketThread(Socket socket) {
        this.socket = socket;
    }

    public void sendMsg(OutputStream outputStream){
        System.out.println("客户端写入数据开始");
        try {
            OutputStreamWriter out = new OutputStreamWriter(outputStream);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                out.write(line);
                //out.write("\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("客户端写入数据结束");
    }

    public void receiveMsg(InputStream inputStream){
        System.out.println("客户端读取数据开始");

        try {
            InputStreamReader in = new InputStreamReader(inputStream);

            int len;
            char[] chars = new char[1024];

            while ((len = in.read(chars,0,1024)) != -1){
                System.out.println(new String(chars,0,len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("客户端读取数据结束");
    }



    public void run() {
        try{
            socket = new Socket("192.168.1.191",8338);

            //SocketInputStream

            //socket = new Socket();

            //socket.connect(new InetSocketAddress(8336));

            System.out.println("客户端："+socket);

            InputStream inputStream =  socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            //OutputStreamWriter out = new OutputStreamWriter(outputStream);

             //InputStreamReader in = new InputStreamReader(inputStream);

            //BufferedOutputStream out = new BufferedOutputStream(outputStream);

            //BufferedInputStream in = new BufferedInputStream(inputStream);

          /*  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                out.write(Thread.currentThread().getName()+"发来信息："+line);
                //out.write("\n");
                out.flush();
            }*/

            new Thread(){
                @Override
                public void run() {
                    receiveMsg(inputStream);
                }
            }.start();

            new Thread(){
                @Override
                public void run() {
                    sendMsg(outputStream);
                }
            }.start();



        }catch (Exception e){

        }finally {

        }

    }
}



public class ClientSocketTest {
    public static void main(String[] args) throws Exception{
        //连接,数据包,心跳包
       /* Executor exec = Executors.newCachedThreadPool();

        exec.execute(new MyClientSocketThread());*/

        //Socket socket = new Socket();
       //socket.connect(new InetSocketAddress("192.168.1.191",8338));

        //Socket socket = new Socket(new Proxy(Proxy.Type.HTTP,new InetSocketAddress("192.168.1.191",8338)));

        //Socket socket = new Socket(new SocketImpl());

        Socket socket = new Socket("192.168.1.191",8338);

        //Socket socket = new Socket(InetAddress.getByName("192.168.1.191"),8338);
        //Socket socket = new Socket(InetAddress.getLocalHost(),8338);

        //Socket socket = new Socket("192.168.1.191",8338,InetAddress.getLocalHost(),57638);

        //SocketInputStream

        System.out.println("客户端："+socket);

        InputStream inputStream =  socket.getInputStream();

        OutputStream outputStream = socket.getOutputStream();

        new Thread(){
            @Override
            public void run() {
                try {
                    InputStreamReader in = new InputStreamReader(inputStream);

                    int len;
                    char[] chars = new char[1024];

                    while ((len = in.read(chars,0,1024)) != -1){
                        System.out.println("客户端收到信息："+new String(chars,0,len));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    OutputStreamWriter out = new OutputStreamWriter(outputStream);

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                    String line = "";
                    while ((line = bufferedReader.readLine()) != null){
                        System.out.println("客户端发送信息："+line);
                        out.write(line);
                        //out.write("\n");
                        out.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
