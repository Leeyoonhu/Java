package big_data.bit.ex1;

public class MethodEx2 {
	public static void main(String[] args) {
		//method call
		method1();
		double num = method2();
		System.out.println("method2()의 반환값은 " +num);
	}
	
	// 반환 타입이 없는 경우
	public static void method1() {
		System.out.println("나는 method1");
	}
	// 반환 타입이 있는 경우
	public static int method2() {
		System.out.println("나는 method2");
		return 1;
	}
}
