package kh.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//버블 정렬
		int [] arr = new int[] {3,2,5,1,6,8};		
		System.out.println(Arrays.toString(arr));
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {  //오름차순
				//SWAP
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		// 버블 정렬 결과
		System.out.println(Arrays.toString(arr));

		
		System.out.println("이름을 , 로 구분하여 입력해주세요.");
		String names = sc.nextLine();
		StringTokenizer strToken = new StringTokenizer(names, ",");
		List<String> nameList = new ArrayList<String>();
		while (strToken.hasMoreTokens()) {
			nameList.add(strToken.nextToken());
		}
		String tmpStr = "";
		// 버블 정렬하기
		for(int i=0; i<nameList.size()-1; i++) {
			for(int j=0; j<nameList.size()-1-i; j++) {
				if(nameList.get(j).hashCode()>nameList.get(j+1).hashCode()) {  //오름차순
				//SWAP
					tmpStr = nameList.get(j);
					nameList.set(j, nameList.get(j+1));
					nameList.set(j+1, tmpStr);
				}
			}
		}
		System.out.println(nameList.toString());
	}
		
}