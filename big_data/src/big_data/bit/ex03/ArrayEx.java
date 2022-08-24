package big_data.bit.ex03;

public class ArrayEx {
	public static void main(String[] args) {
		int[] scores = new int[10];
		// 		선언 		초기화(참조 변수가 해당 값을 참조한다)
		// 정수형 데이터 10개를 저장할 수 있는 배열 생성, scores 참조변수가 해당 값 참조
		System.out.println("scores 배열의 길이 " + scores.length);
		// 배열, 객체는 값을 안넣어도 무조건 초기화됨. 정수는 0, 실수는 0.0, 문자열은 null, 논리형은 false;
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);

		// double 형 배열 선언
		double[] doubleArray = new double[3];	// 기본값 0.0 으로 초기화
		System.out.println(doubleArray[0]);
		
		// String 형 배열 선언
		String[] strArray = new String[2];	// 기본값 null 로 초기화
		System.out.println(strArray[1]);
		
		// boolean 형 배열 선언
		boolean[] boolArray = new boolean[3];	// 기본값 false 로 초기화
		System.out.println(boolArray[0]);

		// int 형 배열 선언
		int[] intArray = {1, 2, 3};
		System.out.println(intArray[0]); // 0번 인덱스의 값 호출
		// 배열에 있는 값들을 원소(요소) or elements 라고 부름
		
	}
}
