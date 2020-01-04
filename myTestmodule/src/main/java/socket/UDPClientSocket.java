package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class UDPClientSocket {

    public static void main(String[] args) throws Exception{

        DatagramSocket datagramSocket = new DatagramSocket();


        new Thread(){
            @Override
            public void run() {
                try {

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

                    String line = "";
                    InetAddress destination = InetAddress.getByName("localhost");
                    DatagramPacket sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length,destination,8896);

                    while ((line = bufferedReader.readLine()) != null){
                        sendPacket.setData(line.getBytes());
                        datagramSocket.send(sendPacket);
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
                    byte[] bytes = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);

                    while (true){
                        datagramSocket.receive(receivePacket);
                        String data = new String(receivePacket.getData() , 0 ,receivePacket.getLength());
                        System.out.println(data);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
