package big_data.bit.ex1;

public class Temp8 {
	public static void main(String[] args) {
		String s1 = "Hello";
		System.out.println(s1.contains("H"));
		System.out.println(s1.endsWith("l"));
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == 'l') {
				System.out.println("중복");
			}
		
		}
		String s2 = " Java";
		char c = 'H';
		int count = 0;
		s1 = s1.concat(s2);
		System.out.println(s1);
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == c) {
				count++;
				System.out.println(c + "가 포함된 횟수 : " + count);
			}
		}
		System.out.println(s1.isBlank());
		String s3 = " ";
		System.out.println(s3.isBlank());
		System.out.println(s2.isBlank());
		System.out.println(s1.indexOf(c, 5));
	}
}
