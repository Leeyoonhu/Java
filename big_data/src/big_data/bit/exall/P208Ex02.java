package big_data.bit.exall;

public class P208Ex02 {
	public static void main(String[] args) {
		// 코드를 실행하면 9, 5, 14를 출력함
		// sumExceptFirst()메서드 하나로 만들기
		System.out.println(sumExceptionFirst(1, 2, 3, 4));
		int[] arr = {2, 3};
		System.out.println(sumExceptionFirst(1, arr));
		System.out.println(sumExceptionFirst(1, 2, 3, 4, 5));
	}
	
	// sumExceptionFirst 실행시 배열 생성 후 정수값 집어넣기
	// 각 값의 1은 출력안되므로 배열길이에 들어가지 않음
	static int sumExceptionFirst(int j, int ...n) {
		int sum = 0;
		for(int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		
		return sum;
	}
}
