package bit_commit_exercise.day01;

// 버스 전용차로 단속 프로그램
// 버스 전용차로에 버스가아닌 다른차종이 주행할 경우 단속
// 단 휴일은 단속x
import static bit_commit_exercise.day01.Ex01.scan;

public class Ex04 {
	public static void main(String[] args) {
		System.out.println("1.월~금, 2.토요일, 3.공휴일");
		System.out.print("요일을 선택하세요(1~3) --> ");
		int choice1 = scan.nextInt();
		if(choice1 == 1) {
			System.out.println("버스 전용차로 단속 중입니다.");
			System.out.println("1.버스, 2.승용차");
			System.out.print("차종을 선택하세요(1,2) --> ");
			int choice2 = scan.nextInt();
			if(choice2 == 1) {
				System.out.println("버스임(단속x)");
			}
			else {
				System.out.println("버스 전용차로 위반!!");
			}
		}
		else {
			System.out.println("토요일, 공휴일은 단속하지 않아요~");
		}
	}
}
