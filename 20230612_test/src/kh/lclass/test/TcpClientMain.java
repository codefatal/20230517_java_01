package kh.lclass.test;

public class TcpClientMain {
	public static void main(String[] args) {
		new TcpClientController().tcpClient("127.0.0.1", 9090);
	}
}
