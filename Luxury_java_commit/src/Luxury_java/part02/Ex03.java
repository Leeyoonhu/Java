package Luxury_java.part02;

// 금액을 입력하면 5만원권부터 1원까지 몇개씩 사용됬는지 출력하는 프로그램 작성
import static Luxury_java.part02.Ex01.scan;

public class Ex03 {
	public static void main(String[] args) {
		System.out.print("금액을 입력하시오>>");
		int money = scan.nextInt();
		System.out.printf("오만원권 %d매\n", money/50000);
		System.out.printf("만원권 %d매\n", (money / 10000) % 5);
		System.out.printf("천원권 %d매\n", (money / 1000) % 10);
		System.out.printf("백원 %d개\n", (money / 100) % 10);
		System.out.printf("오십원 %d개\n", ((money / 10) % 10) / 5);
		System.out.printf("십원 %d개\n", ((money / 10) % 10 % 5));
		System.out.printf("일원 %d개\n", (money % 10));
	}
}
