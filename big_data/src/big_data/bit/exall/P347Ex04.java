package big_data.bit.exall;

// 클래스 이름 중복 재정의
class Dice01 {
	// 1~6사이의 정수만 반환하는 주사위
	int num = (int)(Math.random() * 6) + 1;
	String roll() {
		return String.format("%d", num);
	}
}

public class P347Ex04 {
	public static void main(String[] args) {
		System.out.println(new Dice01().roll());
	}
}
