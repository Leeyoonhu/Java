package big_data.bit.ex03;

public class StringEx01 {
	public static void main(String[] args) {
//		int compareTo(String s)
		System.out.println("c".compareTo("a")); // 사전상으로 얼마만큼 떨어져있는지 
		// s1.compareTo(s2) => s1이 s2보다 뒤면 양수, 앞이면 음수
		System.out.println("c".compareToIgnoreCase("A"));
		// 사전상으로 얼마만큼 떨어져있는지.. 단, 대소문자 구분없이
		System.out.println("c".equals("C")); // false
		System.out.println("c".equalsIgnoreCase("C")); // true 대소문자 구분없이 = igonoreCase
		System.out.println("Hello world".charAt(0)); // 0번째 인덱스 문자 출력
		System.out.println("Hello".concat(" Java")); // Hello에  Java 붙이기
		System.out.println("Hello world".contains(" world")); // Hello world가  world 포함하고있는지
		System.out.println("Hello world".endsWith(" world")); // Hello world가  world 문자열로 끝나는지
		System.out.println("Hello world".indexOf(" world")); // Hello world에서  world 문자열이 나타난 시작의 위치
		System.out.println("Hello world".length()); // length() -->> 메소드
		// 배열의 길이를 나타내는 .length --> 맴버변수(필드)
		System.out.println("Hello world".startsWith("Hell")); // Hello world에서 Hell 이 시작 문자열인지
		System.out.println("Hello world".substring(3)); // Hello world 의 3번째 인덱스에서부터 문자열 출력
		System.out.println("Hello world".toLowerCase()); // 전부 소문자 출력
		System.out.println("Hello world".toUpperCase()); // 전부 대문자 출력
		
		String a = "Hello, Java";
		// 문자열 분리
		String s[] = a.split(","); // 문자열 a를 split(a열 안에 나누고 싶은 구분자) 기준으로 쪼개어 s[] 에 저장
		for(int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}
}
