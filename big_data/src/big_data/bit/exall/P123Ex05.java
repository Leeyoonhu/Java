package big_data.bit.exall;

public class P123Ex05 {
	public static void main(String[] args) {
		// 각 변의 길이 합이 20이하, 각 변 모두가 정수인 직각삼각형 모든 변 구하기
		// a + b + c <= 20
		// a^2 + b^2 = c^2
		// a > 0, b > 0, c > 0
		// for 문 중첩사용
		// a ==? b ==? c ==?
		// c가 1일때 ab비교.. 2일때 비교..
		// c가 1이고 a가 1일때 b비교..
		
		for(int c = 1; c < 19; c++) {
			for(int a = 1; a < 19; a++) {
				for(int b = 1; b < 19; b++) {
					if(a + b + c <= 20) {
						if(((c * c) == (a * a) + (b * b)) == true) {
							System.out.println(a + ", " + b + ", " + c);
						}
					}
				}
			}
		}
		
	
	}
}
