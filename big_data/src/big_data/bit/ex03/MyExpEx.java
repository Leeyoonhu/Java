package big_data.bit.ex03;

class MyExp{
	int base; //밑
	int exp; //지수

	int getValue() { // 거듭제곱을 계산한 다음 반환
		// 거듭제곱 base^exp = base * base * base.. exp번 반복
		// base를 exp번 곱한 값을 저장할 변수 선언
		int total = 1;
		for(int i = 0; i < exp; i++) {
			total *= base;
		}
		return total;
	}
}

public class MyExpEx {
	public static void main(String[] args) {
		MyExp test = new MyExp();
		test.base = 10;
		test.exp = 3;
		System.out.println(test.getValue());
	}
}
