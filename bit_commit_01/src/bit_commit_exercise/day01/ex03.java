package bit_commit_exercise.day01;

// 생존율 출력 프로그램
// 장비를 사용하기까지 시간에 따라 생존율이 달라짐
import static bit_commit_exercise.day01.ex01.scan;

public class ex03 {
	public static void main(String[] args) {
		System.out.print("최초 장비를 사용하기까지 걸린 시간을 입력하세요 -->> ");
		int second = scan.nextInt();
		int rate = 0;
		if(second <= 60) {
			rate = 85;
		}
		else if(second <= 120) {
			rate = 76;
		}
		else if(second <= 180) {
			rate = 66;
		}
		else if(second <= 240) {
			rate = 57;
		}
		else if(second <= 300) {
			rate = 47;
		}
		else if(second > 300) {
			rate = 25;
		}
		if(second <= 300) {
			System.out.printf("생존율 : %d%s", rate, "%");
		}
		else {
			System.out.printf("생존율 : %d%s 미만", rate, "%");
		}
	}
}
