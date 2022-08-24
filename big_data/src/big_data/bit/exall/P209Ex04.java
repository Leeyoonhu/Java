package big_data.bit.exall;

import java.util.Scanner;

public class P209Ex04 {
	public static void main(String[] args) {
		// 키보드에서 URL을 입력받은 후 com으로 끝나는지, java를 포함하는지 조사하는 프로그램 작성
		// bye를 입력하기 전까지 무한반복
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("URL을 입력하세요 : ");
			String url = scan.next();
			if (url.endsWith("com")) {
				System.out.println(url + "은 'com'으로 끝납니다.");
			} 
			if (url.contains("java")) {
				System.out.println(url + "은 'java'를 포함합니다.");
			} 
			if (url.equals("bye")) {
				break;
			}
		}
	}
}
