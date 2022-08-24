package big_data.bit.ex1;

public class IncrementEx {
	public static void main(String[] args) {
		int x = 0;
		System.out.println("increment() 메소드 호출 전의 x : " + x);
		increment(x);	// n = x	값 전달(call by value)
		System.out.println("increment() 메소드 호출 후의 x : " + x);
	}

	private static void increment(int n) {	// n = x
		// TODO Auto-generated method stub	
		System.out.println("increment() 메소드 시작 시의 n : " + n);
		n++;	// n = n + 1;
		System.out.println("increment() 메소드 종료 시의 n : " + n);
	}
	
	
}
