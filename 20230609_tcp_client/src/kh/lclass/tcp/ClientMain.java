package kh.lclass.tcp;

public class ClientMain {
	public static void main(String[] args) {
		new TcpClient().testTcpClient("127.0.0.1", 9090);
	}
}
