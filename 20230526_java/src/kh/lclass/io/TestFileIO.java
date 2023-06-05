package kh.lclass.io;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kh.lclass.exception.UserException;
import kh.lclass.oop.sample.Person;

public class TestFileIO {
	public void testFileOutputStreamObject() {
		Person p1 = new Person("홍길동", 23, '남');
		Person p2 = new Person("영희", 27, 'F');
		
		String filePath = "D:/data2/test/aaa.txt";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			fos = new FileOutputStream(filePath);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {				
				if(oos!=null) oos.close();
				if(fos!=null) fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void testFileIntputStreamObject() {
		String filePath = "D:/data2/test/aaa.txt";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try{
			fis = new FileInputStream(filePath);
			ois = new ObjectInputStream(fis);
			Person a = (Person)(ois.readObject());
			Person b = (Person)(ois.readObject());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {				
				if(ois!=null) ois.close();
				if(fis!=null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void testFileReadData() {		
		String filePath = "D:/data2/test/aaa.txt";
		try(DataInputStream dis = new DataInputStream(new FileInputStream(filePath));){
			 long temp = 0L;
			 while((temp=dis.readLong())!=0) {
				 System.out.println(String.valueOf(temp));
			 }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testFileRead3() {
		String filePath = "D:/data2/test/aaa.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void testRamda() throws UserException {
//		int[] arr = {2,3,4};
//		int[] arr2 = new int[] {2,3,4};
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(arr[i]);
//		}
//		if(arr.length>2) {
//			throw new UserException("배열의 크기는 2보다 크면 안됨. 줄여주세요.");
//		}
	}
	public void testFileRead2() {
		// 보조스트림
		String filePath = "D:/data2/test/aaa.txt";
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
//			isr = new InputStreamReader(new FileInputStream(filePath));
//			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br!=null) br.close();
				if(isr!=null) isr.close(); 
				if(fis!=null) fis.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
				
				
	}
	
	public void testFileRead() {
		String filepath = "D:/data2/test/aaa.txt";
		
		FileReader fr = null;
		try {
			fr = new FileReader(filepath);
			try {
				// Unhandled exception type IOException
				// 사용 불가 for(int i=0; i<fr);
				// 방법 1
//				int a = -1;
//				while((a = fr.read())>-1) {
//					System.out.print((char)a);
//				}
//				System.out.println();
				// 방법 2
				int cntPerRead = 30;
				char[] readCharArr = new char[1000];
				for(int i=0; i<readCharArr.length/50; i++) {					
					int readCnt = fr.read(readCharArr,i*cntPerRead,cntPerRead);
					System.out.println(readCnt);
					System.out.println(readCharArr);
					if(readCnt<50) {
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} finally {
			try {
				if(fr!=null) fr.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=== testFileRead 끝 ===");
	}
	
	public void testFile() /* throws IOException */ {
//		File f1 = new File("D:/data1/aaa.txt");
//		f1.mkdirs();
		String path = "D:/data2/test";
		String filename = "aaa.txt";
		new File(path).mkdirs();
		File f2 = new File(path, filename);
		// Unhandled exception type IOException
		FileWriter fw = null; 
		try {			
			f2.createNewFile();
			
			fw = new FileWriter(f2); // File에 문자 형태 전송이 가능한 OutputStream (file과 java 프로그램의 종료)
			fw.write("한글 한글"); // 전송하고자 하는 문자
			fw.flush(); // 전송한 문자가 담김 버퍼(통로)를 깨끗하게 밀어내기
			return;
		} catch(IOException e) {
			System.out.println("파일 생성 못함");
			e.printStackTrace();
		} finally { // return 전에 반드시 실행하고 넘어가는 문구
			try {			
				if(fw!=null) fw.close(); // 통로를 닫기
			} catch(IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
