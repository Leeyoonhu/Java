package big_data.bit.ex1;

public class OperandEx {
	public static void main(String[] args) {
		int a, b = 4;
//		System.out.printf("연산 전 : a = %d, b = %d", a, b);
		a = b++ + 10;	// b 와 10 연산 먼저 처리 후 b값 증가
		System.out.printf("연산 후 : a = %d, b = %d\n", a, b);
		
		a = 0; b = 4;
		a = ++b + 10;	// b값 증가 후 b와 10 연산 처리
		System.out.printf("연산 후 : a = %d, b = %d\n", a, b);
	}
}
