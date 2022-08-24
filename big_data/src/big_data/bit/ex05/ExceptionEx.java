package big_data.bit.ex05;

public class ExceptionEx {
	public static void main(String[] args) {
		int[] intArray = new int[2];
		intArray[0] = 0;
		intArray[1] = 1;
		try {
//			intArray[2] = 2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage().contains("out of bounds"))
			System.out.println("배열의 범위를 벗어났습니다.");
		}
		finally {
			System.out.println("프로그램을 정상종료함");
		}
	}
}
