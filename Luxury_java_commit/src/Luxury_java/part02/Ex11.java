package Luxury_java.part02;
//숫자를 입력받아 3~5 봄, 6~8 여름, 9~11가을, 12~2 겨울 / 그외 숫자 잘못입력
import static Luxury_java.part02.Ex01.scan;
public class Ex11 {
	public static void main(String[] args) {
		System.out.print("달을 입력하세요(1~12)>>");
		int month = scan.nextInt();
		// 1. if - else 문으로
//		if(month == 12 || (month > 0 && month < 3)) {
//			System.out.println("겨울");
//		}
//		else if(month < 12 && month > 8) {
//			System.out.println("가을");
//		}
//		else if(month < 9 && month > 5) {
//			System.out.println("여름");
//		}
//		else if(month < 6 && month > 2) {
//			System.out.println("봄");
//		}
//		else {
//			System.out.println("1~12사이의 정수만 입력해주세요");
//		}
		
		// 2. switch - case
		switch(month) {
		case 1: case 2: case 12:
			System.out.println("겨울");
			break;
		case 3: case 4: case 5:
			System.out.println("봄");
			break;
		case 6: case 7: case 8:
			System.out.println("여름");
			break;
		case 9: case 10: case 11:
			System.out.println("가을");
			break;
			default:
				System.out.println("1~12사이의 정수만 입력해주세요");
		}
	}
}
