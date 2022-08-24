package big_data.bit.exall;

import java.util.Scanner;

public class P123Ex06 {
	public static void main(String[] args) {
		// 철수와 영희가 가위(s) 바위(r) 보(p) 게임을 한다
		// 승자 또는 무승부를 출력하는 프로그램 작성
		Scanner scan = new Scanner(System.in);
		System.out.print("철수 : ");
		String chul = scan.next();
		System.out.print("영희 : ");
		String young = scan.next();
		if(chul.equals(young)) {
			System.out.println("비겼습니다.");
		}
		else if(((chul.equals("r") && young.equals("s"))) || ((chul.equals("s") && young.equals("p"))) || ((chul.equals("p") && young.equals("r")))) {
			System.out.println("철수, 승!");
		}
		else {
			System.out.println("영희, 승!");
		}
	}
}
