package kh.lclass.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServerBackground {
	private ServerSocket serverSocket;
	private ServerGUI gui;
	private Client client;
	
	// client 여러명을 관리 : key : nickname, value : OutputStream
	private Map<String, BufferedWriter> mapClients = new HashMap<String, BufferedWriter>();
	
	private Socket socket;
	
	private int count; // 현재 접속자 수

	// 서버 생성 및
	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			// 방문자 접속을 계속 받아들임. 무한반복함. GUI 프로그램 경우 창 닫힐때까지 계속 반복됨. break 없음.
			while(true) {
				System.out.println("클라이언트 접속 대기 중");
				// 접속자 대기 중
				socket = serverSocket.accept();
				// 클라이언트 nickname이 바로 이어서 들어옴
				new Client(socket).start();
				System.out.println("클라이언트 접속 완료 : "+socket.getPort());
				count++;
				System.out.println("현재 접속자 수 :"+count);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 클라이언트 접속하면 그 정보를 나타내 주는 메소드
	public void addClient(String nickname) {
		gui.appendMsg(nickname+"님이 접속했습니다.");
	}
	
	
	public void disconnection() {
		try {
			if(socket!=null) {				
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void sendMsg(String msg) {
		Set<String> keySet = mapClients.keySet();
		for(String key : keySet) {			
			BufferedWriter wr = mapClients.get(key);
			try {
				wr.write(msg+"\n");
				wr.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// private ServerSUI gui;
	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}
	
	////// Inner Class //////
	
	class Client extends Thread {
		private Socket socket;
		private BufferedReader br;
		private BufferedWriter bw;
		private String nickname;
		
		public Client(Socket socket) {
			// 초기값 설정
			// client와 입/출력 통로 생성
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				String nickname = br.readLine();
				// server 화면에 표현
				addClient(nickname);
				// client OutputStream 관련
				mapClients.put(nickname, bw);
				// client map 모두에게 접속 정보 전달
				sendMsg(nickname+"님 접속했습니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// client마다 각각에서 전달되어 오는 메세지 확인하고 화면에 출력
			// client와 입력 통로가 끊어지지 않는다면 계속 반복 확인 함. 
			// client에서 수신받은 msg
			while(br!=null) {
				try {
					String msg = br.readLine();
					gui.appendMsg(msg);
					sendMsg(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}


