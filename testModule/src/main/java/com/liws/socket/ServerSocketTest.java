package com.liws.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


class MyServerSocketThread implements Runnable{

    private Socket socket;

    public MyServerSocketThread() {
    }

    public MyServerSocketThread(Socket socket) {
        this.socket = socket;
    }

    public void sendMsg(OutputStream outputStream){
        System.out.println("服务端写入信息开始");

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
        System.out.println("服务端写入信息结束");
    }

    public void receiveMsg(InputStream inputStream){
        System.out.println("服务端读取信息开始");

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
        System.out.println("服务端读取信息结束");
    }

    @Override
    public void run() {
        try {
            InputStream inputStream =  socket.getInputStream();

            OutputStream outputStream = socket.getOutputStream();

            //OutputStreamWriter out = new OutputStreamWriter(outputStream);

            //InputStreamReader in = new InputStreamReader(inputStream);

            //BufferedOutputStream out = new BufferedOutputStream(outputStream);

            //BufferedInputStream in = new BufferedInputStream(inputStream);

            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

          /*  int len;
            char[] chars = new char[1024];

            while ((len = in.read(chars,0,1024)) != -1){
                System.out.println(new String(chars,0,len));
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


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ServerSocketTest {

    public static void main(String[] args){
        /*单线程*/

        /*try{
            ServerSocket serverSocket = new ServerSocket(8338);
            //Scanner scanner = new Scanner(System.in);

            while (true){
                Socket socket = serverSocket.accept();

                InputStream inputStream =  socket.getInputStream();

                OutputStream outputStream = socket.getOutputStream();

                //OutputStreamWriter out = new OutputStreamWriter(outputStream);

                InputStreamReader in = new InputStreamReader(inputStream);

                //BufferedOutputStream out = new BufferedOutputStream(outputStream);

                //BufferedInputStream in = new BufferedInputStream(inputStream);

                //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                int len;
                char[] chars = new char[1024];
                *//*String line = "";
                while ((line = bufferedReader.readLine()) != null){
                    System.out.println("服务端收到的信息:"+line);
                }*//*

                while ((len = in.read(chars,0,1024)) != -1){
                    System.out.println("服务端收到的信息:"+new String(chars,0,len));
                }

*//*                int len;
                //char[] chars = new char[100];
                byte[] bytes = new byte[1024];
                while ((len = in.read(bytes,0,1024)) != -1){
                    System.out.println("收到客户端的信息："+new String(bytes,0,len));

                   *//**//* String str = "好的";
                    out.write(str.getBytes(),0,str.getBytes().length);
                    out.flush();*//**//*
                }*//*

                //TimeUnit.SECONDS.sleep(10);
             }

        }catch (Exception e){

        }*/

        /*多线程*/

/*        try{
            ServerSocket serverSocket = new ServerSocket(8338);
            //Scanner scanner = new Scanner(System.in);

            while (true){
                Socket socket = serverSocket.accept();

                System.out.println("服务端："+socket);


                new Thread(){
                    @Override
                    public void run() {


                        try {
                            InputStream inputStream =  socket.getInputStream();

                            OutputStream outputStream = socket.getOutputStream();

                            //OutputStreamWriter out = new OutputStreamWriter(outputStream);

                            InputStreamReader in = new InputStreamReader(inputStream);

                            //BufferedOutputStream out = new BufferedOutputStream(outputStream);

                            //BufferedInputStream in = new BufferedInputStream(inputStream);

                            //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                            int len;
                            char[] chars = new char[1024];

                            while ((len = in.read(chars,0,1024)) != -1){
                                System.out.println(new String(chars,0,len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }.start();

            }

        }catch (Exception e){

        }*/


        /*线程池*/

        Executor exec = Executors.newCachedThreadPool();

        try{
            ServerSocket serverSocket = new ServerSocket(8338);

            while (true){
                Socket socket = serverSocket.accept();

                System.out.println("服务端："+socket);

                InputStream inputStream =  socket.getInputStream();

                OutputStream outputStream = socket.getOutputStream();

                //exec.execute(new MyServerSocketThread(socket));

                new Thread(){
                    @Override
                    public void run() {
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

        }catch (Exception e){

        }


    }


}
