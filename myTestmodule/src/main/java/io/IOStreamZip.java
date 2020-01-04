package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

public class IOStreamZip {

    public static void main(String[] args) throws Exception{

//        System.out.println("压缩文件gz");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test10.txt"));
//
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
//                                                         new GZIPOutputStream(
//                                                              new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test10.gz")));
//        int c;
//        while ((c = bufferedReader.read()) != -1){
//            bufferedOutputStream.write(c);
//        }
//
//        bufferedReader.close();
//        bufferedOutputStream.close();
//
//        System.out.println("读取压缩文件");
//
//        BufferedReader bufferedReader1 = new BufferedReader(
//                                             new InputStreamReader(
//                                                 new GZIPInputStream(
//                                                     new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test10.gz")),"UTF-8"));
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(
//                                                      new GZIPInputStream(
//                                                          new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.gz")));
//        String line = "";
//        while ((line = bufferedReader1.readLine()) != null){
//            System.out.println(line);
//        }
//        List<Byte> byteList = new ArrayList<>();
//        int b;
//        while ((b = bufferedInputStream.read()) != -1){
//            byteList.add((byte) b);
//        }
//
//        byte[] bytes = new byte[byteList.size()];
//        for (int i = 0; i < byteList.size(); i++){
//            bytes[i] = byteList.get(i);
//        }
//
//        System.out.println(new String(bytes,"UTF-8"));


          FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.zip");
          CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream,new Adler32());
          ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);

          BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);

          zipOutputStream.setComment("A Test of Java Zip");

          //List<BufferedReader> bufferedReaders = new ArrayList<>();
          BufferedReader bufferedReader = null;



          bufferedReader = new BufferedReader(new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test2.txt"));
          //bufferedReaders.add(bufferedReader);
        zipOutputStream.putNextEntry(new ZipEntry("test2/test2.txt"));
            int b;
            while ((b = bufferedReader.read()) != -1){
                bufferedOutputStream.write(b);
            }

            bufferedReader.close();
            bufferedOutputStream.flush();



          bufferedReader = new BufferedReader(new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt"));
        zipOutputStream.putNextEntry(new ZipEntry("test3/test3.txt"));
        while ((b = bufferedReader.read()) != -1){
            bufferedOutputStream.write(b);
        }

        bufferedReader.close();
        bufferedOutputStream.flush();
          //bufferedReaders.add(bufferedReader);




          bufferedReader = new BufferedReader(new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test10.txt"));
        zipOutputStream.putNextEntry(new ZipEntry("test10/test10.txt"));

        while ((b = bufferedReader.read()) != -1){
            bufferedOutputStream.write(b);
        }

        bufferedReader.close();
        bufferedOutputStream.flush();
          //bufferedReaders.add(bufferedReader);


          bufferedOutputStream.close();
    }
}
