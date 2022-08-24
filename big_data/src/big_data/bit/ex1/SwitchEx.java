package big_data.bit.ex1;

public class SwitchEx {
	public static void main(String[] args) {
		int num = 100;
		switch(num) {	// 케이스에 맞는 조건부터 break를 만날 때까지 무조건 출력
		case 1:
			System.out.println("num의 값은 1입니다.");
			break;
		case 2:
			System.out.println("num의 값은 2입니다.");
			break;
		case 3:
			System.out.println("num의 값은 3입니다.");
			break;
			
		default:	// 선택사항
			System.out.println("num은 1도 아니고, 2도 아니고, 3도 아닙니다.");
		}
	}
}
