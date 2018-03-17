package com.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
	public static void main(String[] args)throws IOException{  
        String str_send = "Hello UDPclient";  
        byte[] buf = new byte[1024];  
      
        DatagramSocket ds = new DatagramSocket(30555);  
        //���մӿͻ��˷��͹���������  
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);  
        System.out.println("server is on��waiting for client to send data......");  
        boolean f = true;  
        while(f){  
            //�������˽������Կͻ��˵�����  
            ds.receive(dp_receive);  
            System.out.println("server received data from client��");  
            String str_receive = new String(dp_receive.getData(),0,dp_receive.getLength()) +   
                    " from " + dp_receive.getAddress().getHostAddress() + ":" + dp_receive.getPort();  
            System.out.println(str_receive);  
            
            DatagramPacket dp_send= new DatagramPacket(str_send.getBytes(),str_send.length(),dp_receive.getAddress(),dp_receive.getPort());  
            ds.send(dp_send);  
             
            dp_receive.setLength(1024);  
        }  
        ds.close();  
    }  
}
