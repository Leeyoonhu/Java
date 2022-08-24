package big_data.bit.exall;

// 주사위를 나타내는 Dice 클래스
// 6개의 면(face)와 굴리기 동작이 있다.
// Math.random()함수는 0~1사이의 double타입 무작위 실수
class Dice {
	static int face = 6;
	
	public static int roll() {
		return (int)(Math.random() * face);
	}
}

public class P167Ex08 {
	public static void main(String[] args) {
		Dice d = new Dice();
		System.out.println("주사위의 숫자 : " + d.roll());
	}
}
