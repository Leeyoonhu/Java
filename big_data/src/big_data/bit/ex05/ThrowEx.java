package big_data.bit.ex05;

import java.util.Scanner;

public class ThrowEx {
	
	public static void square(String str) throws Exception {
		int n = Integer.parseInt(str);
		System.out.println(n * n);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			square(scan.next());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("정수가 아닙니다.");
		}
	}
	
}
