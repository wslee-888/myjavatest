package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerSocket {
    public static void main(String[] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(8896);
        byte[] bytes = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(bytes, 0, bytes.length);


        new Thread(){
            @Override
            public void run() {
                try {

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


        new Thread(){
            @Override
            public void run() {
                try {

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String line = "";

                    DatagramPacket sendPacket = null;
                    while ((line = bufferedReader.readLine()) != null){

                        sendPacket = new DatagramPacket(line.getBytes(), line.getBytes().length,receivePacket.getAddress(),receivePacket.getPort());
                        datagramSocket.send(sendPacket);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
