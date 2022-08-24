package big_data.bit.exall;

import java.text.MessageFormat;

public class P348Ex07 {
	public static void main(String[] args) {
		Object[][] data = {{"세종대왕", 1, "조선"}, {"오바마", 2, "미국" }, {"징기스칸", 3, "몽고"}};
		// MessageFormat 사용할 것
		String[] strArray = new String[3];
		for(int i = 0 ; i < strArray.length; i++) {
			strArray[i] = MessageFormat.format("이름 : {0}\t 번호 : {1}\t\t 국적 : {2}", data[i]);
			System.out.println(strArray[i]);
		}
	}
}
