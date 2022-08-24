package big_data.bit.ex1;

public class Temp3 {
	public static void main(String[] args) {
		float f = 3.14f;
		int i = (int)f;
		System.out.println(i);
		
		i = 100;
		char c = (char)i;
		System.out.println(c);
		
		int a = 3;
		a *= a + 1;
		System.out.println(a);
		
		int sum = 0;
		for(int j = 1; j < 10; j +=2) {
			sum += j;
		}
		System.out.println(sum);
	}
}
