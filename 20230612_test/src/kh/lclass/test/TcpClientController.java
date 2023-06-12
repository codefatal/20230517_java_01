package kh.lclass.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientController {
	public void tcpClient(String ip, int port) {
		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			socket = new Socket(ip, port);
			System.out.println("서버 접속 성공");
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			br = new BufferedReader(new InputStreamReader(in));
			wr = new BufferedWriter(new OutputStreamWriter(out));
			
			String sendMsg = null;
			
			while(true) {
				System.out.print("메세지 >> ");
				sendMsg = stdIn.readLine();
				System.out.println("###### "+sendMsg);
				
				wr.write(sendMsg+"\n");
				wr.flush();
				
				String receivedMsg = br.readLine();
				System.out.println("서버 답변 : "+receivedMsg);
			}
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stdIn!=null) stdIn.close();
				if(wr!=null) wr.close();
				if(br!=null) br.close();
				if(out!=null) out.close();
				if(in!=null) in.close();
				if(socket!=null) socket.close();
			} catch(UnknownHostException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
