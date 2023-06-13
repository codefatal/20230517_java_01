package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoReceiver_example {
	public static void main(String[] args) {
		new UdpEchoReceiver_example().UdpReceiver();
	}
	
	public void UdpReceiver() {
		int myPort = 6002;
		
		DatagramSocket dSock = null;
		
		try {
			dSock = new DatagramSocket(myPort);
			
			while(true) {				
				byte[] byteMsg = new byte[1000];
				DatagramPacket receivedMsg
				= new DatagramPacket(byteMsg, byteMsg.length);
				dSock.receive(receivedMsg);
				
				String receivedStr = new String(receivedMsg.getData());
				System.out.println("수신메세지 : "+receivedStr);
				
				String sendMsg = "ㅇㅅㅇ";
				
				byte[] sendByte = sendMsg.getBytes();
				
				DatagramPacket sendData
				= new DatagramPacket(sendByte, sendByte.length, receivedMsg.getAddress(), receivedMsg.getPort());
				dSock.send(sendData);
			}
		} catch(SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
