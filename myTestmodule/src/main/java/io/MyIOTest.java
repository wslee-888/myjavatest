package io;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MyIOTest {

    public static void main(String[] args) {

        /*早期的阻塞式io流*/

        //字节的输入流和输出流
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        //StringBufferInputStream stringBufferInputStream;
        FileInputStream fileInputStream;
        PipedInputStream pipedInputStream;
        SequenceInputStream sequenceInputStream;
        FilterInputStream filterInputStream;
        ObjectInputStream objectInputStream;
        DataInputStream dataInputStream;
        BufferedInputStream bufferedInputStream;
        PushbackInputStream pushbackInputStream;
        //LineNumberInputStream lineNumberInputStream;
        GZIPInputStream gzipInputStream;

        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream;
        PipedOutputStream pipedOutputStream;
        FilterOutputStream filterOutputStream;
        ObjectOutputStream objectOutputStream;
        BufferedOutputStream bufferedOutputStream;
        DataOutputStream dataOutputStream;
        PrintStream printStream;
        GZIPOutputStream gzipOutputStream;


        //字符的输入流和输出流
        Reader reader;
        PipedReader pipedReader;
        PushbackReader pushbackReader;
        CharArrayReader charArrayReader;
        FilterReader filterReader;
        InputStreamReader inputStreamReader;
        StringReader stringReader;
        BufferedReader bufferedReader;
        FileReader fileReader;
        LineNumberReader lineNumberReader;

        Writer writer;
        PrintWriter printWriter;
        BufferedWriter bufferedWriter;
        StringWriter stringWriter;
        FilterWriter filterWriter;
        CharArrayWriter charArrayWriter;
        PipedWriter pipedWriter;
        OutputStreamWriter outputStreamWriter;
        FileWriter fileWriter;

        /*后期的非阻塞nio流*/
        Buffer buffer;
        ByteBuffer byteBuffer;
        CharBuffer charBuffer;
        DoubleBuffer doubleBuffer;
        FloatBuffer floatBuffer;
        IntBuffer intBuffer;
        LongBuffer longBuffer;
        ShortBuffer shortBuffer;

        MappedByteBuffer mappedByteBuffer;

        Channel channel;
        FileChannel fileChannel;
        DatagramChannel datagramChannel;
        SocketChannel socketChannel;
        ServerSocketChannel serverSocketChannel;

        Selector selector;


        /*nio基础上改进的aio*/

    }

}
