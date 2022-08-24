package big_data.bit.exall;

public class P208Ex01 {
	public static void main(String[] args) {
		//문자열과 문자를 매개변수로 받는 메서드가 있다
		// 문자열 s에 포함된 문자 c의 갯수 반환
		System.out.println(countChar("ABCCCC", 'C'));
	}
	static int countChar(String s, char c) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				count++;
			}
		}
		return count;
	}
}
