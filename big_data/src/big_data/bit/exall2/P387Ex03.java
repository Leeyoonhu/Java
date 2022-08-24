package big_data.bit.exall2;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class P387Ex03 {
	public static void main(String[] args) {
		String s = "of the people, by the people, for the people";
		try {
			showTokens(s, ",");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("��");
		}
	}
	// while(true){} �� ����ϴ� showTokens() �޼��� �߰�
	static void showTokens(String s1, String s2) {
		StringTokenizer st = new StringTokenizer(s1, " ,");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		st.nextToken();
	}
}
