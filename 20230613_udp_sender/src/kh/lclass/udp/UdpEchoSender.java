package kh.lclass.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpEchoSender {
	public static void main(String[] args) {
		new UdpEchoSender().senderUdp();
	}
	
	public void senderUdp() {
		int myPort = 5001;
		int destPort = 6001;
		String destName = "localhost";
		
		DatagramSocket dSock = null;
		BufferedReader br = null;
		try {			
			dSock = new DatagramSocket(myPort);
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.print("입력 >> ");
				String sendMsg = br.readLine();
				
				// exit 입력하면 프로그램 종료
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
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
				byte[] byteMsg = new byte[1000];
				DatagramPacket receivedData 
				= new DatagramPacket(byteMsg, byteMsg.length);
				dSock.receive(receivedData);
				
				System.out.println("=== 전달받은 정보들 ===");
//				System.out.println(byteMsg.length);
//				System.out.println(receivedData.getData().length);
//				System.out.println(receivedData.getAddress());
//				System.out.println(receivedData.getPort());
				String receivedStr = new String(receivedData.getData());
				System.out.println("수신메세지 : "+receivedStr);
			}			
		} catch(SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(dSock!=null) dSock.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		
	}
}
;