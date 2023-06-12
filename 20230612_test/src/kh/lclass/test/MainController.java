package kh.lclass.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainController {
	public void fileSave() {
		String filePath = "a.txt";
		try(
			FileWriter fw = new FileWriter(filePath);
			BufferedWriter bw = new BufferedWriter(fw);
			){
			String str = "Hello World";
			bw.append(str);
			bw.flush();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String fileRead() {
		String filePath = "b.txt";
		String str = "";
		try(
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			){
			str = br.readLine();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
