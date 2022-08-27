package bit_commit_exercise.day02;

// n단의 숫자 피라미드 만들기
import java.util.*;

public class Ex01 {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.print("정수를 입력하세요 >> ");
		int n = scan.nextInt();
		int space = (n - 1);
		// i 가 2i -1 개씩 출력
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= (2 * i)-1; k++) {
				System.out.print(i % 10);
			}
			space--;
			System.out.println();
		}
	}
}
