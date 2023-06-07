package kh.lclass.vo;

import java.util.StringTokenizer;

public class TestApi {
	public void TestString() {
		StringBuffer str1 = new StringBuffer("aaa");
		StringBuffer str2 = new StringBuffer();
		str2.append("12345");
		str2.insert(2,"abc");
		System.out.println(str2);
		System.out.println(str2.indexOf("bc"));
		StringBuilder str3 = new StringBuilder("bbb");
		str3.insert(1, "111");
		System.out.println(str3);
		
		String str = "AA|BB|CC";
		StringTokenizer st = new StringTokenizer(str, "|");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
