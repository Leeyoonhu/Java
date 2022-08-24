package big_data.bit.ex1;

public class Exercise10 {
	public static void main(String[] args) {
		// 0~100 정수중 3과 8의 공배수와 최소 공배수 출력하기
		int num = 1;
		int lcm = 0, cm; // 최소공배수 lcm 공배수 cm
		while (num < 101) {
			if(num % 3 == 0 && num % 8 == 0) {
				cm = num;
				System.out.printf("공배수 : %d\n", cm);
				if(lcm == 0) {
					lcm = cm;
				}
			}
			num ++;
		}
		System.out.printf("최소공배수 : %d", lcm);
	}
}
