package big_data.bit.ex05;

public class Exercise03 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb.hashCode());
		System.out.println(sb.append(" is pencil"));
		System.out.println(sb.insert(7, " my"));
		System.out.println(sb.replace(8, 10, "your"));
		sb.setLength(5);
		System.out.println(sb);
		System.out.println(sb.hashCode());
	}
}
