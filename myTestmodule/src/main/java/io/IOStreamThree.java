package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.*;

public class IOStreamThree {

    public static void main(String[] args) throws Exception{
        //NativeDispatcher
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");

        FileChannel readChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //ByteBuffer byteBuffer = ByteBuffer.wrap("记录HD按件捯气儿".getBytes());

        //ByteBuffer byteBuffer = ByteBuffer.wrap("记录HD按件捯气儿".getBytes(),0,"记录HD按件捯气儿".getBytes().length);

        //ByteBuffer byteBuffer = ByteBuffer.allocateDirect(8192);


       /* readChannel.read(byteBuffer);
        byteBuffer.flip();
        byte[] bytes = byteBuffer.array();
        System.out.println(new String(bytes,byteBuffer.position(),byteBuffer.limit()));*/

        //byteBuffer.arrayOffset();

        /*readChannel.read(byteBuffer);
        byteBuffer.compact();//将未操作的数据上移到容器的顶部
        byteBuffer.clear();//可以理解为清空容器
        byteBuffer.capacity();
        byteBuffer.duplicate();//复制原来的buffer,但是，复制后的缓冲区get和put所操作的数组还是与原始缓冲区一样的，所以对复制后的缓冲区进行修改也会修改原始的缓冲区
        byteBuffer.flip();//调整容器位置，利于读写操作

        byteBuffer.get();
        byteBuffer.get(8);
        byteBuffer.get(new byte[1024]);
        byteBuffer.get(new byte[1024],0,1024);

        byteBuffer.getChar();
        byteBuffer.getChar(98);

        byteBuffer.getDouble();
        byteBuffer.getDouble(98);

        byteBuffer.getFloat();
        byteBuffer.getFloat(98);

        byteBuffer.getInt();
        byteBuffer.getInt(98);

        byteBuffer.getLong();
        byteBuffer.getLong(98);

        byteBuffer.getShort();
        byteBuffer.getShort(98);

        byteBuffer.hasArray();//是否可数组化缓冲容器的内容
        byteBuffer.hasRemaining();//是否有可操作的内容

        byteBuffer.isReadOnly();//是否只读
        byteBuffer.isDirect();//字节缓冲区是否为直接。

        byteBuffer.limit();
        byteBuffer.limit(8);

        byteBuffer.mark();//标记缓冲区的当前位置position。

        byteBuffer.order();//获取此缓冲区的字节顺序。在读写多字节值以及为此字节缓冲区创建视图时使用该字节顺序。新创建的字节缓冲区的顺序始终为 BIG_ENDIAN。
        byteBuffer.order(null);//修改此缓冲区的字节顺序,新的字节顺序，要么是 BIG_ENDIAN，要么是 LITTLE_ENDIAN

        byteBuffer.position();
        byteBuffer.position(8);

        byteBuffer.put((byte)8);
        byteBuffer.put("舒服舒服".getBytes());
        ByteBuffer bbf = ByteBuffer.wrap("记录HD按件捯气儿".getBytes());
        byteBuffer.put(bbf);
        byteBuffer.put(8,(byte) 8);
        byteBuffer.put("是否发生第三个".getBytes(),0,"是否发生第三个".getBytes().length);

        byteBuffer.putDouble(8.8d);
        byteBuffer.putDouble(6,8.8d);

        byteBuffer.putFloat(8.8f);
        byteBuffer.putFloat(6,8.8f);

        byteBuffer.putInt(8);
        byteBuffer.putInt(6,8);

        byteBuffer.putLong(8l);
        byteBuffer.putLong(6,8l);

        byteBuffer.putShort((short) 8);
        byteBuffer.putShort(6,(short)8);

        byteBuffer.putChar('c');
        byteBuffer.putChar(6,'c');

        byteBuffer.remaining();//返回容器可操作的数量
        byteBuffer.rewind();//倒带，使得可按照已有内容重新操一遍
        byteBuffer.reset();//回到标志的位置

        byteBuffer.slice();//分片创建缓存对象，但数据容器和原来的一样，创建新的字节缓冲区，其内容是此缓冲区内容的共享子序列。新缓冲区的内容将从此缓冲区的当前位置开始。此缓冲区内容的更改在新缓冲区中是可见的，反之亦然；这两个缓冲区的位置、界限和标记值是相互独立的。
         */


       /* System.out.println("position:"+byteBuffer.position());

        System.out.println("limit:"+byteBuffer.limit());


        int len = readChannel.read(byteBuffer);


        List<Byte> byteList = new ArrayList<>();
        while (len != -1){

            System.out.println("len:"+len);

            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                byteList.add(byteBuffer.get());
            }

            byteBuffer.clear();


            len = readChannel.read(byteBuffer);
        }

        fileInputStream.close();

        byte[] bytes = new byte[byteList.size()];

        for (int i = 0; i < byteList.size(); i++){
            bytes[i] = byteList.get(i);
        }

        System.out.println(new String(bytes));*/

       /* readChannel.read(byteBuffer,10);//从内容position位置开始读取
        byteBuffer.flip();
        byte[] bytes = byteBuffer.array();
        System.out.println(new String(bytes,byteBuffer.position(),byteBuffer.limit()));*/


        //ByteBuffer[] byteBuffers = new ByteBuffer[]{ByteBuffer.allocate(60),ByteBuffer.allocate(60),ByteBuffer.allocate(9)};

        //readChannel.read(byteBuffers);//分散读取数据到每个容器

        //readChannel.read(byteBuffers,2,1);//分散读取数据到每个容器,控制从哪个容器开始读取和使用几个容器来读取

        /*for (ByteBuffer bbf:byteBuffers){
            bbf.flip();

            byte[] bytes = bbf.array();
            System.out.println(new String(bytes,bbf.position(),bbf.limit()));
        }*/


        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test8.txt",true);

        FileChannel writeChannel = fileOutputStream.getChannel();

        //ByteBuffer byteBuffer2 = ByteBuffer.allocate(100);

        //ByteBuffer byteBuffer2 = ByteBuffer.wrap("记录HD按件捯气儿".getBytes());

        //byteBuffer2.put("爱情故事上集".getBytes());

        //byteBuffer2.flip();
        //writeChannel.write(byteBuffer2);

        //writeChannel.write(byteBuffer2,9);//从position位置开始写，和写入内容没关系

        //把多个容器进行收集写入
        //ByteBuffer[] byteBuffers = new ByteBuffer[]{ByteBuffer.wrap("驱蚊器日日".getBytes()),ByteBuffer.wrap("安顿好简单法分开过".getBytes())};

        //writeChannel.write(byteBuffers);

        //writeChannel.write(byteBuffers,1,1);//控制从哪个容器开始读取和使用几个容器来读取


        //writeChannel.close();

        //readChannel.transferTo(10,100,writeChannel);
        //writeChannel.transferFrom(readChannel,9,20);

        //readChannel.position(10);

        //readChannel.position();


       /* readChannel.position(9);

        System.out.println(readChannel.position());

        System.out.println(readChannel.size());

        readChannel.read(byteBuffer);

        byteBuffer.flip();

        System.out.println(new String(byteBuffer.array(),byteBuffer.position(),byteBuffer.limit()));*/
        //readChannel.close();





        //bytebuffer字节缓冲器转换为其他的数据类型视图缓冲器，其实共用了同一个数据组
/*        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        ByteBuffer bb = byteBuffer.asReadOnlyBuffer();*/



       /* readChannel.read(byteBuffer);

        byteBuffer.flip();

        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        System.out.println("直接读取乱码："+charBuffer);

        byteBuffer.rewind();

        String encoding = System.getProperty("file.encoding");

        System.out.println("对字节内容按"+encoding+"方式解码:"+Charset.forName(encoding).decode(byteBuffer));*/

//        byteBuffer.rewind();
//
//        System.out.println("按数据视图："+new String(byteBuffer.asCharBuffer().array()));



/*        writeChannel.write(ByteBuffer.wrap("设置返回是否含税福建省反馈".getBytes("UTF-16BE")));

        writeChannel.close();

        readChannel = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test8.txt").getChannel();

        byteBuffer.clear();

        readChannel.read(byteBuffer);

        byteBuffer.flip();

        System.out.println("UTF-16BE编码："+byteBuffer.asCharBuffer());*/




     /*   writeChannel = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test9.txt",true).getChannel();

        byteBuffer.asCharBuffer().put("舒舒服服哈哈哈哈哈哈");

        writeChannel.write(byteBuffer);

        writeChannel.close();*/

/*        readChannel = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt").getChannel();

        byteBuffer.clear();

        readChannel.read(byteBuffer);
        byteBuffer.flip();

        //String str = "";
        List<Byte> byteList = new ArrayList<>();
        while (byteBuffer.hasRemaining()){

            //System.out.println(new String(byteBuffer.array(),byteBuffer.position(),byteBuffer.limit()));

            //str += new String(byteBuffer.array(),byteBuffer.position(),byteBuffer.limit());

            for(int i = byteBuffer.position() ; i < byteBuffer.limit(); i++){
                byteList.add(byteBuffer.get(i));
            }

            readChannel.read(byteBuffer);

            byteBuffer.flip();
        }

        byte[] bytes = new byte[byteList.size()];

        for(int i = 0 ; i < byteList.size() ; i++){
            bytes[i] = byteList.get(i);
        }

        System.out.println(new String(bytes));*/


/*        readChannel = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test9.txt").getChannel();


        readChannel.read(byteBuffer);

        byteBuffer.flip();

        System.out.println(byteBuffer.asCharBuffer());*/






       /* byteBuffer.asCharBuffer().put('8');

        System.out.println(byteBuffer.getChar());

        byteBuffer.asIntBuffer().put(88);

        System.out.println(byteBuffer.getInt());

        byteBuffer.asDoubleBuffer().put(88.8);

        System.out.println(byteBuffer.getDouble());*/


        //数据视图使用自己的属性(position offset)操作bytebuffer
/*        byteBuffer.putChar('a');

        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        byteBuffer.flip();
        //charBuffer.flip();
        System.out.println("111111:"+charBuffer.get());
        //System.out.println("222222:"+byteBuffer.get());
        System.out.println("222222:"+byteBuffer.getChar());*/

/*        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        charBuffer.put('c');

        byteBuffer.putChar('b');

        charBuffer.flip();

        System.out.println(charBuffer.get());

        //System.out.println(byteBuffer.get());

        System.out.println(byteBuffer.getChar());*/

//        byteBuffer.flip();
//        System.out.println(byteBuffer.asCharBuffer().get());
//        System.out.println(byteBuffer.asCharBuffer().get());
//        System.out.println(byteBuffer.getChar());



       /* IntBuffer intBuffer = byteBuffer.asIntBuffer();

        intBuffer.put(new int[]{11,22,33,55,66,88,99});


        System.out.println(intBuffer.get(3));

        intBuffer.put(3,118);

        intBuffer.flip();

        System.out.println(intBuffer.get());

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }*/


  /*     byteBuffer = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});

       byteBuffer.rewind();

        System.out.println("bytebuffer:");

       while (byteBuffer.hasRemaining()){
           System.out.println("position:"+byteBuffer.position()+"->"+byteBuffer.get());
       }

       byteBuffer.rewind();

       System.out.println(byteBuffer.get());


        CharBuffer charBuffer = byteBuffer.asCharBuffer();
       System.out.println("charbuffer:");

       while (charBuffer.hasRemaining()){
           System.out.println("position:"+charBuffer.position()+"->"+charBuffer.get());
       }

       IntBuffer intBuffer = byteBuffer.asIntBuffer();
        System.out.println("intBuffer:");

        while (intBuffer.hasRemaining()){
            System.out.println("position:"+intBuffer.position()+"->"+intBuffer.get());
        }

        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        System.out.println("shortBuffer:");

        while (shortBuffer.hasRemaining()){
            System.out.println("position:"+shortBuffer.position()+"->"+shortBuffer.get());
        }

        LongBuffer longBuffer = byteBuffer.asLongBuffer();
        System.out.println("longBuffer:");

        while (longBuffer.hasRemaining()){
            System.out.println("position:"+longBuffer.position()+"->"+longBuffer.get());
        }

        FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
        System.out.println("floatBuffer:");

        while (floatBuffer.hasRemaining()){
            System.out.println("position:"+floatBuffer.position()+"->"+floatBuffer.get());
        }

        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        System.out.println("doubleBuffer:");

        while (doubleBuffer.hasRemaining()){
            System.out.println("position:"+doubleBuffer.position()+"->"+doubleBuffer.get());
        }

        byteBuffer = byteBuffer.wrap(new byte[12]);
        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));

        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.BIG_ENDIAN);

        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));


        byteBuffer.rewind();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

        byteBuffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(byteBuffer.array()));*/





        //readChannel.force(true);//强行将留在缓存未写出的数据刷出到磁盘上
        //readChannel.truncate(1024);//读取该长度的数据

        //内容映射缓存器
/*        int length = 8192;

        MappedByteBuffer mappedByteBuffer = new RandomAccessFile("C:\\Users\\fcz01\\Desktop\\poi\\test6.txt","rw").getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);

        for (int i = 0; i < length; i++){
            mappedByteBuffer.put((byte)'w');
        }

        System.out.println("finished writing");

        for (int i = length/2; i < length/2 + 6; i++){
            System.out.println((char)mappedByteBuffer.get(i));
        }*/



        //对内容进行加锁
/*        readChannel.lock();
        readChannel.lock(0,10,true);
        readChannel.tryLock();
        readChannel.tryLock(0,10,true);*/

        //nio通道常用工具类：Channels


        //java的压缩打包工具
        CheckedInputStream checkedInputStream;
        CheckedOutputStream checkedOutputStream;
        DeflaterInputStream deflaterInputStream;
        DeflaterOutputStream deflaterOutputStream;
        ZipOutputStream zipOutputStream;
        ZipInputStream zipInputStream;
        GZIPOutputStream gzipOutputStream;
        GZIPInputStream gzipInputStream;
        InflaterInputStream inflaterInputStream;
        InflaterOutputStream inflaterOutputStream;

    }
}
