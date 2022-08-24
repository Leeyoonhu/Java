package big_data.bit.exall;



public class P347Ex05 {
	public static void main(String[] args) {
		// String, StringBulier, StringBuffer의 부모클래스에 show(String s) 함수 작성
		Object obj = new Object();
		show(new String("멘붕"));
		show(new StringBuilder("meltdown"));
		show(new StringBuffer("!@#"));
		 
//		show(new Date()); 오류 발생
	}
	private static void show(String string) {
			// TODO Auto-generated method stub
		System.out.println(string);
	}
	

	private static void show(StringBuilder stringBuilder) {
		// TODO Auto-generated method stub
		System.out.println(stringBuilder);
	}

	private static void show(StringBuffer stringBuffer) {
		// TODO Auto-generated method stub
		System.out.println(stringBuffer);
	}

	
}
