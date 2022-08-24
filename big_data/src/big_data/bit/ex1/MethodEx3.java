package big_data.bit.ex1;

public class MethodEx3 {
	public static void main(String[] args) {
		int i = 1, j = 10;
		int k = sum(i,j);
		System.out.println(k);
	}

	private static int sum(int i, int j) {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int a = i; a <= j; a++) {
			sum+= a;
		}
		return sum;
	}
	
}
