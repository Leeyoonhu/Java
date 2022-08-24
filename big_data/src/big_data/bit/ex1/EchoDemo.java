package big_data.bit.ex1;

public class EchoDemo {
	public static void main(String[] args) {
		echo("안녕!", 3);
	}

	private static void echo(String string, int i) {
		// TODO Auto-generated method stub
		for(int j = 0; j < i; j++) {
			System.out.println(string);
		}
	}
}
