package big_data.bit.ex1;

public class Exercise15 {
	public static void main(String[] args) {
		// 두개의 정수를 입력받아 사칙연산을 수행하는 메소드 작성하고 실행
		int i = 2, j = 3;
		System.out.printf("%d와 %d의 합은 %d\n", i, j, add(i, j));
		System.out.printf("%d와 %d의 차는 %d\n", i, j, minus(i, j));
		System.out.printf("%d와 %d의 곱은 %d\n", i, j, multi(i, j));
		System.out.printf("%d 나누기 %d은 %f", i, j, divide(i, j));
	}

	private static int add(int i, int j) {
		return i + j;
	}

	private static int minus(int i, int j) {
		return i - j;
	}

	private static int multi(int i, int j) {
		return i * j;
	}

	private static double divide(int i, int j) {
		return (double)i / j;
	}

	
}
