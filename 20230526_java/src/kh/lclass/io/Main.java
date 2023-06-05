package kh.lclass.io;

import java.io.IOException;

import kh.lclass.oop.sample.Kh;

public class Main {
	public static void main(String[] args) throws IOException {
		TestFileIO tf = new TestFileIO();
//		tf.testFile();
//		tf.testFileRead();
//		tf.testFileRead2();
//		try {
//			tf.testRamda();	
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		new TestFileIO().testFileReadData();
		new TestFileIO().testFileOutputStreamObject();
		new TestFileIO().testFileIntputStreamObject();
		System.out.println("===main끝===");
//		Kh kh = new Kh();
//		kh.khSpecial();
	}

}
