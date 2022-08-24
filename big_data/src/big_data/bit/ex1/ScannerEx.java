package big_data.bit.ex1;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 이름(String), 주소(String), 나이(int), 키(double) 순서로 입력 받을 것
		// 입력만 받으면 뭘 입력해야하는지 알기 힘드므로 안내하기 위해서 안내 문구 출력
		System.out.println("이름, 주소, 나이, 키 순서대로 입력하세요.");
		String name = scan.next(); // 할당 연산자 '=' >> 우항을 좌항에 대입
		// scan에서 입력되는 정보를 구별할때 사용 space, tap, enter
		String address = scan.next();
		int age = scan.nextInt();
		double height = scan.nextDouble();

		System.out.printf("사용자가 입력한 이름은 %s, 주소는 %s, 나이는 %d, 키는 %.1f", name, address, age, height);
		
	}
}
