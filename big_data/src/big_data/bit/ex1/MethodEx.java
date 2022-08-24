package big_data.bit.ex1;

public class MethodEx {
	public static void main(String[] args) {
		// 1-10
		sum(1, 10);
		// 1-100
		sum(1, 100);
		// 100-1000
		sum(100, 1000);
		// 다른 메서드 호출 -->> method call
		// call 할때는 메서드의 이름을 불러주고, 매개변수에 값을 입력
		// 메인을 간결하게 할수록 가독성이 뛰어남
	}
// 메소드 정의(선언)
// 메소드 이름도 식별자, 대체로 소문자로 시작
// 매개변수를 argument, parameter.. 정의할때는 argument(인자), 호출할때는 parameter(매개변수)
// void 자리에는 반환타입이오는데 void는 반환할 값이 없는 타입임
	static void sum(int num1, int num2) {
		int total = 0;
		for (int i = num1; i <= num2; i++) {
			total += i;
		}
		System.out.printf("(%d-%d)까지의 합 %d\n", num1, num2, total);
	}
}
