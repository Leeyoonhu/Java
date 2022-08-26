package Luxury_java.part02;

// 달러를 원화로 바꾸는 프로그램 작성
// $1 == 1100원
import java.util.*;
public class Ex01 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("원화를 입력하세요(단위 원)>>");
		int won = scan.nextInt();
		double dollor = won/1100;
		System.out.printf("%d원은 $%.1f입니다.", won, dollor);
	}
}
