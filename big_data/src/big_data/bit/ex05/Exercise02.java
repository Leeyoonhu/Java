package big_data.bit.ex05;

public class Exercise02 {
	public static void main(String[] args) {
		String[] strArray = {"23", "12", "998", "3.141592"};
		for(int i = 0; i < strArray.length; i++) {
			try {
				System.out.println("숫자로 변환된 값은 "+Integer.parseInt(strArray[i]));
				// Integer.parseInt(String str) ==> String 문자열 안에 포함된 정수 반환
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("정수로 변환할 수 없습니다.");
			}
		}
		System.out.println(Double.parseDouble("1.023"));
		// Double.parseDouble(String str) ==> String 문자열 안에 포함된 실수 반환
	}
}
