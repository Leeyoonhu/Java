package big_data.bit.ex1;

import static big_data.bit.ex1.Exercise01.scan;

public class Exercise02 {
	public static void main(String[] args) {
		// 97개의 빵을 3개씩 같은반 친구에게 나누어준다
		// 몇명에게 나눠줄수있는지와 남는 빵 갯수 구하기
		System.out.print("빵의 갯수를 입력하세요 >> ");
		int bread = scan.nextInt();
		System.out.print("몇개씩 나누어줄지를 입력하세요 >> ");
		int count = scan.nextInt();
		System.out.println("빵을 나누어 줄 수 있는 학생의 수 : " + bread / count);
		System.out.println("남는 빵 개수 : " + bread % count);
	}
}
