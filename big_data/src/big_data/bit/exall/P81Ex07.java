package big_data.bit.exall;

import java.util.Scanner;

public class P81Ex07 {
	public static void main(String[] args) {
		// 키보드로 정수를 입력받는다
		// 1. 4와 5로 나누어지는지?
		// 2. 4또는 5로 나누어지는지?
		// 3. 4나 5중 하나로 나누어지지만 두수모두로는 나누어지지 않는지
		Scanner scan = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = scan.nextInt();
		System.out.println((num % 4 == 0 && num % 5 == 0)? "true" : "false");
		System.out.println((num % 4 == 0 || num % 5 == 0)? "true" : "false");
		System.out.println((num % 4 == 0 ^ num % 5 == 0)? "true" : "false");
		
	}
}
