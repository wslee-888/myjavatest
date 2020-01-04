package io;

public class IOStreamTwo {

    public static void main(String[] args) throws Exception{

        //CharArrayReader charArrayReader = new CharArrayReader("一生热爱难回头".toCharArray());

       /* int c;
        while ((c = charArrayReader.read()) != -1){
            System.out.println((char)c);
        }*/

/*        int len;
        char[] chars = new char[10];
        while ((len = charArrayReader.read(chars,0,10)) != -1){
            System.out.println(new String(chars,0,len));
        }*/

        //CharArrayWriter charArrayWriter = new CharArrayWriter(10);

        //charArrayWriter.write(97);

//        charArrayWriter.write("爱福家解放军",0,"爱福家解放军".length());
//        FileWriter fileWriter = new FileWriter("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt",true);
//        charArrayWriter.writeTo(fileWriter);
//
//        charArrayWriter.append("方式方法付是否");
//
//        //fileWriter.flush();
//        //fileWriter.close();
//
//        charArrayWriter.flush();
//        charArrayWriter.close();


        //StringReader stringReader = new StringReader("十多个哈哈发挥好按时发发三个社人员市工商局教育局");

       /* int i;
        while ((i = stringReader.read()) != -1){
            System.out.println((char)i);
        }*/

       /* int len;
        char[] chars = new char[5];
        while ((len = stringReader.read(chars,0,5)) != -1){
            System.out.println(new String(chars,0,len));
        }*/

       /* StringWriter stringWriter = new StringWriter();

        stringWriter.write(97);

        stringWriter.write("阿萨斯故事梗概".toCharArray());

        stringWriter.write("阿萨斯故事梗概".toCharArray(),0,"阿萨斯故事梗概".toCharArray().length);

        stringWriter.write("舒服舒服计数法");

        stringWriter.write("舒服舒服计数法",0,"舒服舒服计数法".length());


        stringWriter.append('a');

        stringWriter.append("a");

        stringWriter.append("asfs",0,"asfs".length());*/

        //FilterReader filterReader;
        //FilterWriter filterWriter;


        /*        InputStream in = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(in,"utf-8");//readBytes

        int b;
        while ((b = inputStreamReader.read()) != -1){
            System.out.println((char)b);
        }

        int len;
        char[] c = new char[10];
        while ((len = inputStreamReader.read(c,0,10)) != -1){
            System.out.println(new String(c,0,len));
        }*/

        //OutputStream out = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt",true);
        //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out);//writeBytes

        //outputStreamWriter.write(97);

        //outputStreamWriter.write("奥术大师啊发放经济法".toCharArray(),0,8);

        //outputStreamWriter.write("S解释分解爱福家",0,"S解释分解爱福家".length());

        //outputStreamWriter.flush();

        //outputStreamWriter.close();

        //FileReader fileReader = new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
        //FileWriter fileWriter = new FileWriter("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");

       /* int c;
        while ((c = fileReader.read()) != -1){
            System.out.println((char)c);
        }


        int len;
        char[] chars = new char[1024];

        while ((len = fileReader.read(chars,0,1024)) != -1){
            System.out.println(new String(chars,0,len));
        }*/

       /* fileWriter.write(98);
        fileWriter.write("是否是个帅哥公司".toCharArray());
        fileWriter.write("阿双方均萨法咖啡客服");
        fileWriter.write("俺家是金发放卡首付款".toCharArray(),0,"俺家是金发放卡首付款".toCharArray().length);
        fileWriter.write("按时发发静安寺附近",0,"按时发发静安寺附近".length());
        fileWriter.flush();*/

        //FileReader fileReader = new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
        //BufferedReader bufferedReader = new BufferedReader(fileReader);

        //FileInputStream fileInputStream = new FileInputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream,"gb2312"));

      /*  int c;
        while ((c = bufferedReader.read()) != -1){
            System.out.println((char)c);
        }

        int len;
        char[] chars = new char[1024];
        while ((len = bufferedReader.read(chars,0,1024)) != -1){
            System.out.println(new String(chars,0,len));
        }*/

        /*String line = "";
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }*/

       /* Stream<String> stringStreams = bufferedReader.lines();
        Iterator<String> iter = stringStreams.iterator();

        //迭代器
        while (iter.hasNext()){
            System.out.println(iter.next());
        }*/


        //FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
        //BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));


        //FileWriter fileWriter = new FileWriter("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt",true);
        //BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        /*bufferedWriter.write(100);
        bufferedWriter.write("是三国杀打广告".toCharArray());
        bufferedWriter.write("按时付款时方可观看".toCharArray(),0,"按时付款时方可观看".toCharArray().length);
        bufferedWriter.write("按时发生发生发顺丰");
        bufferedWriter.write("爱的好卡erei", 0, "爱的好卡erei".length());*/

        //bufferedWriter.newLine();
        //bufferedWriter.flush();
        //bufferedWriter.close();

        //PipedReader pipedReader = new PipedReader();
        //PipedWriter pipedWriter = new PipedWriter();

        //pipedReader.connect(pipedWriter);
        //pipedWriter.connect(pipedReader);

        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //InputStreamReader isr = new InputStreamReader(System.in);

        //String line = "";
       /* char[] chars = new char[1024];
        int len;
        while ((len = isr.read(chars,0,1024)) != -1){
            pipedWriter.write(new String(chars,0,len));
            //out.write("\n");
            pipedWriter.flush();
        }*/


   /*     pipedWriter.write("你好啊发顺丰");


        char[] chars = new char[1024];
        int len;
        while ((len = pipedReader.read(chars,0,1024)) != -1){
            System.out.println("管道读取信息："+new String(chars,0,len));
        }*/

       /* FileReader fileReader = new FileReader("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt");
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

        String str = "";
        while ((str = lineNumberReader.readLine()) != null){
            System.out.println("第"+lineNumberReader.getLineNumber()+"行信息："+str);
        }*/

        //FileWriter fileWriter = new FileWriter("C:\\Users\\fcz01\\Desktop\\poi\\test3.txt",true);
        //PrintWriter printWriter = new PrintWriter(fileWriter);
        //String s = "Hello World";
        //int d = 125;
        //%(\d+\$)?([-#+ 0,(\<]*)?(\d+)?(\.\d+)?([tT])?([a-zA-Z%])
        // create a new writer
        //PrintWriter pw = new PrintWriter(System.out);

        // printf text with default locale.
        // %s indicates a string will be placed there, which is s
        //pw.printf("This is a %d program", d);

        // change line
        //pw.println();

        // printf text with default locale
        // %d indicates a integer will be placed there, which is 100
        //pw.printf("This is a %s program with %d", s, 100);

        // flush the writer
        //pw.flush();

        //PushbackReader pushbackReader = new PushbackReader();
    }
}
