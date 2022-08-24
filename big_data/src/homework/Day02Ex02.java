package homework;

import java.util.Scanner;

public class Day02Ex02 {
	public static void main(String[] args) {
		// A회사는 3대의 컴퓨터로 8시간씩일하면 하루 업무 처리가능 (총24시간이상 일을하면 하루에 업무를 처리할수있는데)
		// 단축근무하여 근무시간이 줄어듬 (일은 8시간 아래로 무조건내려가네 컴퓨터 댓수가 늘어난다)
		// 총 근무시간을 맞추기 위해 필요한 컴퓨터 수량 파악 프로그램 작성
		// 변수이름은 뭘 넣든 상관없는데
		// 기본타입 8가지 넣으면안되고
		Scanner scan = new Scanner(System.in);
		System.out.print("근무시간을 입력하시오 --> ");
		int hour = scan.nextInt();
		int totalTime = 24, computer = 0; //3 시간 * computer >= 24
		while (true) {
			computer++; // 1번째 실행 3 * 1 >= 24; 2번째 실행 3*2 >= 24; ..... 3 * 8 >=24;
			if(hour * computer >= totalTime) { 
				break;  // 30시간일때 무조건 컴퓨터한대 +hrs 
			}
		}
		System.out.printf("필요한 컴퓨터 수량은 %d", computer);
	}
}
