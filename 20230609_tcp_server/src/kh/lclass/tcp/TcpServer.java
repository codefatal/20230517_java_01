package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	public void testTcpServer(int port) {		
		ServerSocket ss = null;
		Socket sc = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		BufferedWriter wr = null;
		try {
			ss = new ServerSocket(port);
			
			while(true) {				
				System.out.println("클라이언트 접속 대기 중......");
				
				sc = ss.accept();
				System.out.println("클라이언트 접속됨 : "+sc.getPort());
				in = sc.getInputStream();
				out = sc.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(in));
				wr = new BufferedWriter(new OutputStreamWriter(out));
				
				String receivedMsg = null;
				while((receivedMsg = br.readLine())!=null) {
					System.out.println("받은 메세지 : "+receivedMsg);
					wr.write("메세지 잘 받았음\n");
					wr.flush();
				}
			}			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(wr!=null) wr.close();
				if(br!=null) br.close();
				if(out!=null) out.close();
				if(in!=null) in.close();
				if(sc!=null) sc.close();
				if(ss!=null) ss.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
