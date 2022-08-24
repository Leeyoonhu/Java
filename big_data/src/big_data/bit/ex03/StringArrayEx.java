package big_data.bit.ex03;

public class StringArrayEx {
	public static void main(String[] args) {
		String[] strArray = new String[4];
		System.out.println("값을 입력하기 전");
		for(int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		strArray[0]="Hello"; strArray[1]="Java";
		System.out.println("값을 입력한 후");
		for(int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		
	}
}
