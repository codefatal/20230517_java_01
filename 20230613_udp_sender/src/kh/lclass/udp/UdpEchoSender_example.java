package kh.lclass.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpEchoSender_example {
	public static void main(String[] args) {
		new UdpEchoSender_example().UdpSender(); 
	}
	
	public void UdpSender() {
		int myPort = 5002;
		int destPort = 6002;
		String destName = "localhost";
		DatagramSocket dSock = null;
		BufferedReader br = null;
		
		try {
			dSock = new DatagramSocket(myPort);
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("입력 >> ");
				String sendMsg = br.readLine();
				if(sendMsg.equals("exit")) {
					break;
				}
				
				InetAddress destIp = null;
				
				try {
					destIp = InetAddress.getByName(destName);
					byte[] byteMsg = sendMsg.getBytes();
					DatagramPacket sendData
					= new DatagramPacket(byteMsg, byteMsg.length, destIp, destPort);
					
					dSock.send(sendData);
				} catch(UnknownHostException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
				
				byte[] byteMsg = new byte[1000];
				DatagramPacket receivedMsg
				= new DatagramPacket(byteMsg, byteMsg.length);
				dSock.receive(receivedMsg);
				
				String receivedStr = new String(receivedMsg.getData());
				System.out.println("수신메세지 : "+receivedStr);
				
			}
			
			
		} catch(SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
