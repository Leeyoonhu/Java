package big_data.bit.ex03;

public class StringEx {
	public static void main(String[] args) {
//		String a = " abcd def ";
//		String b = "\nxyz\n";
//		System.out.println("==== 트림 전 ==== ");
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println("==== 트림 후 ==== ");
//		
//		// trim() = 문자열 앞 뒤 공백을 제거
//		String c = a.trim();
//		String d = b.trim();
//		System.out.println(c);
//		System.out.println(d);
//		
		String a = "class....";	//   => c l a s s 
							//	index	0 1 2 3 4
		char c = a.charAt(2); // a변수의 문자열 3번째 위치를 변수c에 초기화
		System.out.println(c);
		
		// 문자열 변수 a 의 길이
		System.out.println("a의 글자수 : "+a.length());
		
		// 변수 a 가 s 를 몇개 포함하고있는지 확인
		int count = 0;
		c = 's';
		for(int i = 0; i < a.length(); i ++) {
			if(a.charAt(i) == c) {
				count++;
			}
		}
		System.out.println("a가 포함하고 있는 s의 갯수 : " + count);
		
		
	}
}
