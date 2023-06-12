package kh.lclass.test;

public class Main {
	public static void main(String[] args) {
		MainController mc = new MainController();
		mc.fileSave(); // 파일 저장
		System.out.println(mc.fileRead()); // 파일 불러오기
	}
}
