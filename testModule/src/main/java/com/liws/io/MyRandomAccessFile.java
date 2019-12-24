package com.liws.io;

import java.io.*;
import java.nio.channels.FileChannel;


class OSExecute{
    public static void command(String command){
        boolean err = false;
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();

            System.out.println("666666");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class MyRandomAccessFile {
    public static void main(String[] args) throws Exception{
        //随记读取file,多种模式mode: r,rw,rws,rwd
        //RandomAccessFile randomAccessFile = new RandomAccessFile("","");

        //RandomAccessFile randomAccessFile = new RandomAccessFile(new File("C:\\Users\\fcz01\\Desktop\\poi\\test5.txt"),"rw");

        //FileDescriptor fileDescriptor = randomAccessFile.getFD();
        /*
        *
        *   FileDescriptor是"文件描述符".

            FileDescriptor可以被用来表示开放的文件,开放的套接字等.

            当FileDescriptor表示文件来说,当FIleDescriptor表示某文件时,我们可以通俗的将FIleDescriptor看成该文件.但是,我们不能直接通过FIleDescriptor对该文件进行操作;若需要通过FIleDescriptor对该文件进行操作,则需要创建FileDescriptor对应的FileOutputStream,再对文件进行操作.

            in,out,err的介绍
             in:标准输入(键盘)的描述符
            out:标准输出(屏幕)的描述符
            err:标准错误输出(屏幕)的描述符
        * */

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }*/

/*        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        bufferedWriter.write("哈哈开发费哈弗");
        bufferedWriter.close();*/

/*        PrintStream console = System.out;

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt"));

        PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test6.txt")));

        PrintStream printStream2 = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test7.txt")));


        System.setIn(bufferedInputStream);

        System.setOut(printStream);

        System.setErr(printStream2);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            //System.out.println(line);

            System.err.println(line);
        }
        //printStream.close();
        //System.setOut(console);
        printStream2.close();*/


        //long n = randomAccessFile.getFilePointer();

        //System.out.println(randomAccessFile.length());
        //randomAccessFile.setLength(12);//设置内容长度

        //FileChannel fileChannel = randomAccessFile.getChannel();

        //randomAccessFile.seek(11);移动内容的位置

       /* byte[] bytes = new byte[1024];
        int len;
        while ((len = randomAccessFile.read(bytes,0,1024)) != -1){
            System.out.println(new String(bytes,0,len));
        }*/

        //randomAccessFile.write(97);

        //DataInputStream,DataOutputStream,ObjectInputStream,ObjectOutputStream
    }
}
