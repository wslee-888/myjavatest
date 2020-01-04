package socket;


import com.alibaba.fastjson.JSON;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class UrlSocket {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://192.168.1.191/outapi/doBizTask?type=3");//URN
        //URI uri = new URI();

        URLConnection urlConnection = url.openConnection();
        //urlConnection.setRequestProperty("Request-Method","GET");
        urlConnection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        OutputStream output = urlConnection.getOutputStream();

        String paramStr = "";
        Map<String,Object> params = new HashMap<>();
        params.put("biz","test");

        paramStr = JSON.toJSONString(params);

       /* StringBuffer sb = new StringBuffer();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, Object> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            sb.substring(0, sb.length() - 1);
        }

        paramStr = sb.toString();
        if (paramStr.endsWith("&")) {
            paramStr = paramStr.substring(0, paramStr.length()-1);
        }*/



        output.write(paramStr.getBytes());
        output.flush();
        output.close();

        InputStream input = urlConnection.getInputStream();
        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }
        input.close();

/*        URL url = new URL("file:/C:/Users/fcz01/Desktop/poi/test.txt");

        URLConnection urlConnection = url.openConnection();
        InputStream input = urlConnection.getInputStream();

*//*        int data = input.read();
        while(data != -1){
            System.out.print((char) data);
            data = input.read();
        }*//*

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        input.close();
        bufferedReader.close();*/
    }
}
