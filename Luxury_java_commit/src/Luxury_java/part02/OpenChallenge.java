package Luxury_java.part02;

// 두 사람(철수, 영희)이 하는 가위바위보
// 가위바위보 결과 출력
import java.util.*;

public class OpenChallenge {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		System.out.print("철수 >> ");
		String p1 = scan.next();
		System.out.print("영희 >> ");
		String p2 = scan.next();
		whoIsWin(p1, p2);
	}
	
	static void whoIsWin(String str1, String str2) {
		if(str1.equals(str2)) {
			System.out.println("비겼습니다");
		}
		else if(str1.equals("가위")) {
			if(str2.equals("바위")) {
				System.out.println("영희가 이겼습니다");
			}
			else {
				System.out.println("철수가 이겼습니다.");
			}
		}
		else if(str1.equals("바위")) {
			if(str2.equals("보")) {
				System.out.println("영희가 이겼습니다.");
			}
			else {
				System.out.println("철수가 이겼습니다.");
			}
		}
		else if(str1.equals("보")) {
			if(str2.equals("가위")) {
				System.out.println("영희가 이겼습니다.");
			}
			else {
				System.out.println("철수가 이겼습니다.");
			}
		}
	}
}

