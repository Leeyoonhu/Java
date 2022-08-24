package big_data.bit.ex05;

public class StringEx {
	public static void main(String[] args) {
		String a = "Hello";
		String b = " Java";
		a = a.concat(b);
		StringBuffer sb = new StringBuffer("a");
		sb.append(" pencil"); // >> a pencil
		sb.insert(2, "nice "); // >> a nice pencil
		sb.replace(2, 6, "bad"); // a bad pencil
		sb.delete(0, 2); // bad pencil
		sb.reverse(); // licnep dab
		int n = sb.length(); // n = 10
		char c = sb.charAt(3); // c = n
		System.out.println(n);
		System.out.println(c);
		System.out.println(sb);
	
	}
}
