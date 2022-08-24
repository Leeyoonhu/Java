package big_data.bit.ex1;

public class Temp2 {
	public static void main(String[] args) {
		int x = 1, y = 2;
		System.out.println(x++);
		System.out.println(++x + y--);
		System.out.println(++x / 3 + x * ++y); // ++ 4/3 + 4 * 2
	}
}
