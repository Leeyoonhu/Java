package big_data.bit.exall2;

class Pair<T> {
	T num1;
	T num2;
	public Pair(T num1, T num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public T first() {
		return num1;
	}
	
	public T second() {
		return num2;
	}
}

// 실행결과 참조 메인 메서드 작성
public class P387Ex04 {
	public static void main(String[] args) {
		Pair<Integer> p1 = new Pair<Integer>(10, 20);
		Pair<Double> p2 = new Pair<Double>(10.0, 20.0);
		
		System.out.println(p1.first());
		System.out.println(p2.second());
	}
}
