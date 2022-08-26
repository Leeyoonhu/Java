package Luxury_java.part02;

// 2자리수 정수(10~99)를 입력받고 10의자리와 1의자리가 같은지 판별하는 프로그램 작성
import static Luxury_java.part02.Ex01.scan;

public class Ex02 {
	public static void main(String[] args) {
		System.out.print("2자리 정수 입력(10~99)>>");
		int num = scan.nextInt();
		if(num/10 == num%10) {
			System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
		}
		else {
			System.out.println("No! 10의 자리와 1의 자리가 다릅니다.");
		}
	}
}
