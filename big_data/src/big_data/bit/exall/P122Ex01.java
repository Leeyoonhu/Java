package big_data.bit.exall;

import java.util.Scanner;

public class P122Ex01 {
	public static void main(String[] args) {
		// 키보드로 입력한 정수가 19이상 성년, 아니면 미성년
		// if- else 문 사용할것
		Scanner scan = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int num = scan.nextInt();
		if(num >= 19) {
			System.out.println("성년");
		}
		else {
			System.out.println("미성년");
		}
	}
}
