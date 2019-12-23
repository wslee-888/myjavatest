package io;

public class IOStreamOne {
    public static void main(String[] args) throws Exception{

       /* String str = " ";
        System.out.println(Integer.valueOf(str.charAt(0)));*/

/*        String s = "365淘券aHDHA大家阿斯加德";
        for (int i = 0; i < s.length(); i++){
            System.out.println(s.codePointAt(i));
        }*/

        //ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("365淘券aHDHA大家阿斯加德sfsfsfsfffjoewuworuhaogaoGOFFIAFO".getBytes("gbk"));

/*        int i;
        List<Byte> bytes1 = new ArrayList<>();
        //StringBuffer sb = new StringBuffer();
        while ((i = byteArrayInputStream.read()) != -1){
            //sb.appendCodePoint(i);
            bytes1.add((byte)i);
        }

        byte[] bytes2 = new byte[bytes1.size()];

        for (int d = 0; d < bytes1.size(); d++){
            bytes2[d] = bytes1.get(d);
        }

        System.out.println(new String(bytes2,"gbk"));*/

        //System.out.println(sb.toString());

       /* int[] codeArr = new int[codeList.size()];
        for(int c = 0; c < codeList.size(); i++){
            codeArr[c] = codeList.get(c);
        }*/

        //byteArrayInputStream.close();

        //byteArrayInputStream.reset();

/*        int len;
        byte[] b = new byte[20];
        String data = "";
        while ((len = byteArrayInputStream.read(b,0,20)) != -1){
            data += new String(b,0,len);
        }

        System.out.println(data);*/


        //ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        //byteArrayOutputStream.write((int)'a');

        //byteArrayOutputStream.write("一万年sad胜多负少反间谍法绝地逢".getBytes());

        //byteArrayOutputStream.writeTo(new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt"));

        //byteArrayOutputStream.write("啊发放沙发斯蒂芬".getBytes(), 0, 3);

        //byte[] bytes = byteArrayOutputStream.toByteArray();
        //System.out.println(new String(bytes));

        //byteArrayOutputStream.flush();


        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\testSequence1.txt");
        //String data = "";

       /* int i;
        while ((i = fileInputStream.read()) != -1){
            //System.out.println(i);
        }*/

/*        int len;
        byte[] b = new byte[6];
        //StringBuilder sb = new StringBuilder();
        while ((len = fileInputStream.read(b)) != -1){
            //System.out.println(len);
            data += new String(b,0,len);
        }

        System.out.println(data);*/

        //baozoudashijian暴走大事件又和大家见面，荆轲刺秦王，我们下周再见，什么gui,nmb

        /*int len;
        byte[] b = new byte[10];
        while ((len = fileInputStream.read(b, 0,10)) != -1){
            data += new String(b,0,len);
        }

        System.out.println(data);*/

        //FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.txt");

        //FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.txt", true);

        //fileOutputStream.write((int)'m');

        //fileOutputStream.write("暴走大事件asfjsaf;safjs收代理费看电视逢狼时刻水电费收款感受到刚开始sdfsdf".getBytes());

        //fileOutputStream.write("草泥马".getBytes(), 0, 9);

        //fileOutputStream.flush();

        //fileOutputStream.close();

        //PipedInputStream pipedInputStream = new PipedInputStream();

        //PipedOutputStream pipedOutputStream = new PipedOutputStream();

        //pipedInputStream.connect(pipedOutputStream);

        //pipedOutputStream.connect(pipedInputStream);

        //pipedOutputStream.write((int)'a');

        //System.out.println((char)pipedInputStream.read());


        //pipedOutputStream.write("你好吗".getBytes());

       /* int len;
        byte[] b = new byte[5];
        while ((len = pipedInputStream.read(b, 0, 5)) != -1){
            System.out.println(new String(b,0,len));
        }*/

        //Vector<InputStream> inputStreams = new Vector<>();
       //FileInputStream f1 = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\testSequence1.txt");
       // FileInputStream f2 = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\testSequence2.txt");
       // FileInputStream f3 = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\testSequence3.txt");

        //inputStreams.add(f1);
        //inputStreams.add(f2);
        //inputStreams.add(f3);


        /*int k;
        //String str = "";
        byte[] b1 = new byte[1024];
        List<Byte> byteList = new ArrayList<>();
        while ((k = f1.read(b1,0,1024)) != -1){
            //str += new String(b1,0,i,"gb2312");

            for (int t = 0; t < k; t++){
                byteList.add(b1[t]);
            }
        }

        byte[] bytes = new byte[byteList.size()];
        for (int j = 0; j < byteList.size(); j++){
            bytes[j] = byteList.get(j);
        }
        System.out.println(new String(bytes,"gb2312"));//*/


        //序列流,一个个地读取,拥有整合多个输入流的功能
       /* SequenceInputStream sequenceInputStream = new SequenceInputStream(inputStreams.elements());

        int len;
        byte[] b = new byte[1024];
        while ((len = sequenceInputStream.read(b,0,1024)) != -1){
            System.out.println(new String(b, 0, len));
        }*/

        //InputStream in = new ByteArrayInputStream("365淘券aHDHA大家阿斯加德sfsfsfsfffjoewuworuhaogaoGOFFIAFO".getBytes("UTF-8"));

        //System.out.println("lenght:"+"365淘券aHDHA大家阿斯加德sfsfsfsfffjoewuworuhaogaoGOFFIAFO".getBytes("utf-8").length);
        //String data = null;

        //FilterInputStream filterInputStream = new DataInputStream(in);

        //FileInputStream in = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.txt");

        //DataInputStream dataInputStream = new DataInputStream(in);

        //System.out.println("3的utf-8码："+(int)'3');

        //byte[] b = new byte[65];

        //dataInputStream.read(b);

        //dataInputStream.read(b,0,1024);

        /*try {
            //dataInputStream.readFully(b);

            dataInputStream.readFully(b, 0, 65);

        } catch (IOException e) {

        } finally {
            //一次性读取所有，并相应地放到数组中
            System.out.println(new String(b,"utf-8"));
        }*/

/*        int count = 0;

        try {

*//*            while (true){
                boolean b = dataInputStream.readBoolean();
                System.out.println(b);
            }*//*
//
           *//* while (true){
                byte b = dataInputStream.readByte();
                System.out.println(b);
            }*//*


           *//* while (true){
               //UTF-16
                char c = dataInputStream.readChar();
                System.out.println(c);
            }*//*
//
//            dataInputStream.readDouble();
//
//            dataInputStream.readFloat();
//
//            dataInputStream.readInt();
//
              //dataInputStream.readLong();
//
//            dataInputStream.readShort();
//
//            while (true){
//                System.out.println(dataInputStream.readUnsignedByte());
//                count ++;
//            }

            //dataInputStream.readUnsignedShort();

//            while (true){
//                System.out.println(dataInputStream.readUTF());
//            }
        } catch (IOException e) {
          e.printStackTrace();
        } finally {
            System.out.println("count:"+count);
        }*/

       /* try {
            while (true){
                //char c = dataInputStream.readChar();
                //System.out.println(c);

                Double d = dataInputStream.readDouble();
                System.out.println(d);
            }

        } catch (IOException e) {

        } finally {

        }*/
      /*  DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(in));
        String str = "";
        try {
            while (true){
                str = dataInputStream.readUTF();
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        }*/

        //OutputStream out = new ByteArrayOutputStream();

        //FileOutputStream out = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.txt",true);

        //FilterOutputStream filterOutputStream = new FilterOutputStream(out);

        //DataOutputStream dataOutputStream = new DataOutputStream(out);

        //dataOutputStream.writeBoolean(true);

        //dataOutputStream.writeByte(65);

        //dataOutputStream.writeBytes("12.3");

        //dataOutputStream.writeChar('a');

        //dataOutputStream.writeChars("一生热爱难回头");

        //dataOutputStream.writeDouble(12.3d);

        //dataOutputStream.writeFloat(12.3f);

        //dataOutputStream.writeInt(2356897);

        //dataOutputStream.writeLong(20l);

        //dataOutputStream.writeShort(10);


        //dataOutputStream.writeUTF("暴走大事件，荆轲刺秦王");

        //dataOutputStream.flush();

        //InputStream in = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.txt");
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(in);

       /* int b;
        while ((b = bufferedInputStream.read()) != -1){
            System.out.println(b);
        }*/

       /* int len;
        byte[] bytes = new byte[1024];
        String data = "";

        while ((len = bufferedInputStream.read(bytes,0,1024)) != -1){
            data += new String(bytes,0,len,"gb2312");
        }

        System.out.println(data);*/


        //OutputStream out = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test.txt",true);

        //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);

        //bufferedOutputStream.write(97);

        //byte[] bytes = new byte[1024];

        //bufferedOutputStream.write("1223456啊啊架飞5689asfsafasf机艾弗森".getBytes(),0, "1223456啊啊架飞机艾弗森".getBytes().length);

        //bufferedOutputStream.flush();

        //bufferedOutputStream.close();

/*        OutputStream out = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\TestIOObject.data");//TestIOObject.data


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(new TestIOObject(13,"想起那天夕阳下奔跑的我，那是我逝去的青春"));

       // objectOutputStream.writeBoolean(true);

        //objectOutputStream.write("什么gui,你mb".getBytes("utf-8"),0,"什么gui,你mb".getBytes("utf-8").length);

        //objectOutputStream.defaultWriteObject();

        //objectOutputStream.flush();

        objectOutputStream.close();*/


       /*InputStream in = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test2.txt");

        ObjectInputStream objectInputStream = new ObjectInputStream(in);

        //TestIOObject testIOObject = (TestIOObject)objectInputStream.readObject();
        //System.out.println(testIOObject);

        //Boolean b = objectInputStream.readBoolean();
        //System.out.println(b);

        int len;
        byte[] bytes = new byte[1024];
        while ((len = objectInputStream.read(bytes,0,1024)) != -1){
            System.out.println(new String(bytes,0,len,"utf-8"));
        }

        objectInputStream.close();*/

       //InputStream in = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
       //PushbackInputStream pushbackInputStream = new PushbackInputStream(in,1024);
        //LineNumberInputStream lineNumberInputStream = new LineNumberInputStream();

/*        int b;
        List<Byte> byteList = new ArrayList<>();
        while ((b = pushbackInputStream.read()) != -1){
            byteList.add((byte)b);
        }

        byte[] bytes = new byte[byteList.size()];

        for (int i = 0; i < byteList.size(); i++){
            bytes[i] = byteList.get(i);
        }

        System.out.println(new String(bytes));*/

        /*int len;
        byte[] bytes = new byte[10];
        while ((len = pushbackInputStream.read(bytes,0,10)) != -1){
            pushbackInputStream.unread("暗示法咖啡开发".getBytes(),0,len);
        }*/


       /* String str = "一万年sad胜多负少反间谍法绝地逢";

        for (int i = 0; i < str.length(); i++){
            System.out.println(str.codePointAt(i));
        }*/

        /*OutputStream out = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");

        PrintStream printStream = new PrintStream(out);
        printStream.print("123456");

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str = scanner.nextLine();
            printStream.write(str.getBytes("gb2312"),0,str.getBytes("gb2312").length);
        }*/

        //System.out.println(536870911&(-536870912));//536870911
    }

}
