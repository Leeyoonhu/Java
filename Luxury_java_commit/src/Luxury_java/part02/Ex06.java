package Luxury_java.part02;
// 369 게임 (1~99까지 정수), 3,6,9중 하나 들어가면 박수에 짝 더하고, 둘이면 짝짝
import static Luxury_java.part02.Ex01.scan;
public class Ex06 {
	public static void main(String[] args) {
		System.out.print("1~99 사이의 정수를 입력하시오>>");
		int num = scan.nextInt();
		System.out.print("박수");
		if((num % 10) == 3 || (num % 10) == 6 || (num % 10) == 9) {
			System.out.print("짝");
		}
		if((num / 10) == 1 || (num / 10) == 2 || (num / 10) == 3) {
			System.out.print("짝");
		}
	}
}
