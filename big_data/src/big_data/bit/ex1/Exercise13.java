package big_data.bit.ex1;

import java.util.Scanner;

public class Exercise13 {
	public static void main(String[] args) {
		// 키보드로부터 2자리 양수를 입력받아 출력할때까지 무한반복하는 프로그램 작성
		// 1. 키보드로부터 정수 입력받음
		// 2. 해당 정수가 2자리인지?
		// 3. 2자리면 출력
		// 4. 2자리 출력될때까지 무한 반복
		Scanner scan = new Scanner(System.in);	
		System.out.println("2자리의 정수를 입력하세요");	
		while (true) {	
			System.out.print("입력 >> ");		
			int num = scan.nextInt();	
			if((num / 10) >= 1 && (num / 10) < 10) {	
				System.out.printf("입력받은 정수의 값은 %d임", num);	
				break;	
			}
		 }
		

	}
}
