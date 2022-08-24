package big_data.bit.ex05;

public class ClassEx {
	public static void main(String[] args) {
		String str = new String("abc");
		Class c1 = str.getClass();
		System.out.println(c1);
		System.out.println(c1.getName());
		System.out.println(c1.getSimpleName());
		
		try {
			Class c2 = Class.forName("java.lang.Object");
			System.out.println(c2);
			System.out.println(c2.getName());
			System.out.println(c2.getSimpleName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 클래스 이름을 찾을 수 없음!! 형식 : Class.forName(패키지명.클래스)");
		}
	}
}
