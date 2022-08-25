package bit_commit_exercise.day01;

// A 회사는 3대의 컴퓨터로 8시간을 일하면 하루 업무 처리 가능
// 그런데 코로나로 단축근무 실행
// 평소처럼 하루 업무를 처리하려면 필요한 컴퓨터 대수 구하기
import static bit_commit_exercise.day01.ex01.scan;

public class ex02 {
	public static void main(String[] args) {
		System.out.print("근무시간을 입력하시오--> ");
		int hour = scan.nextInt();
		int computer = 1;
		while(true) {
			if(hour * computer < 24) {
				computer++;
			}
			else {
				break;
			}
		}
		System.out.printf("필요한 컴퓨터 수량은 %d", computer);
	}
}
