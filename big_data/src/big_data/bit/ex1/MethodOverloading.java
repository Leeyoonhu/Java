package big_data.bit.ex1;

public class MethodOverloading {
	public static void main(String[] args) {
		int num1 = 2, num2 = 3;
		System.out.printf("%d와 %d의 합은 %d\n", num1, num2, add(num1, num2));
		System.out.printf("%.1f와 %.1f의 합은 %.1f\n", (double)num1, (double)num2, add((double)num1, (double)num2));
		System.out.printf("%s와 %s의 합은 %s\n", "2", "3", add("2", "3"));
	}

	// 메소드 오버로딩
	// 컴파일러가 매개변수의 타입을 보고 알아서 메서드를 골라 쓴다
	// 매개변수 타입이 다르거나 갯수가 달라야만 오버로딩으로 봄
	private static int add(int num1, int num2) {
		return num1 + num2;
	}
	// 타입과 매개변수는 같으나 반환타입이 다른경우 오버로딩에 해당되지 않음
	// 컴파일러 입장에서는 어떤 메서드를 사용하려는지 알 수 없기 때문
	private static double add(double num1, double num2) {
		return num1 + num2;
	}
	private static String add(String num1, String num2) {
		return num1 + num2;
	}
}
