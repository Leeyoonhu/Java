package big_data.bit.ex1;

public class OverloadDemo {
	public static void main(String[] args) {
		int i1 = 3, i2 = 7, i3 = 10;
		double d1 = 7.0, d2 = 3.0;
		
		System.out.printf("max(%d, %d) = %d\n", i1, i2, max(i1, i2));
		System.out.printf("max(%.1f, %.1f) = %.1f\n", d1, d2, max(d1, d2));
		System.out.printf("max(%d, %d, %d) = %d\n", i1, i2, i3, max(i1, i2, i3));
	}

	private static int max(int i1, int i2) {
		int max;
		if(i1 > i2) {
			max = i1;
		}
		else {
			max = i2;
		}
		return max;
	}

	private static double max(double d1, double d2) {
		double max;
		if(d1 > d2) {
			max = d1;
		}
		else {
			max = d2;
		}
		return max;
	}
	
	private static int max(int i1, int i2, int i3) {
		int max = i1;
		if(max < i2) {
			max = i2;
		}
		if(max < i3) {
			max = i3;
		}
		return max;
	}

	
}
