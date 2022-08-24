package big_data.bit.ex1;

import java.util.Scanner;

public class IfEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("당신의 점수를 입력하세요..");
		try {
			int N = scan.nextInt();
			for(int i =0; i <N; i++) {
				int score = scan.nextInt(); // 수험생의 점수
				// 점수가 80점 이상이면 합격, 그 외에 불합격
				// 입력받은 만큼 반복
				if (score >= 80) { // if 의 시작
					// 조건이 참일 경우
					System.out.println("당신은 합격임..");
					System.out.println("축하합니다.");
					System.out.println("맛있는 거 사드세요.");
				} // if의 끝
				else {
					// 조건이 거짓일 경우 
					System.out.println("당신은 불합격임..");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("미스매치 다시 넣어주세요");
			
		}
		
	}
}
