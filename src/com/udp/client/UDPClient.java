package com.udp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception{
		DatagramSocket socket = new DatagramSocket();
		
		String requestMessage = "Request Something......";
		String ip = "30.117.104.33";
		DatagramPacket packet = new DatagramPacket(requestMessage.getBytes(), 
				requestMessage.length(), 
				InetAddress.getByName(ip), 
				30555);
		socket.send(packet);
		byte[] buf = new byte[1024];
		DatagramPacket dp_receive = new DatagramPacket(buf, 1024);
		socket.receive(dp_receive);
		String receiveMsg = "Msg comes from "+dp_receive.getAddress() + ": " + new String(dp_receive.getData());
		System.out.println(receiveMsg);
		

	}

}
