package big_data.bit.exall;

public class P124Ex09 {
	public static void main(String[] args) {
		foo("안녕", 1);
		foo("안녕하세요", 1, 2);
		foo("잘 있어");
	}
	
	private static void foo(String string, int i) {
		// TODO Auto-generated method stub
		System.out.printf("%s %d\n", string, i);
	}

	private static void foo(String string, int i, int j) {
		// TODO Auto-generated method stub
		System.out.printf("%s %d %d\n", string, i, j);
	}

	private static void foo(String str) {
		System.out.println(str);
	}
}
