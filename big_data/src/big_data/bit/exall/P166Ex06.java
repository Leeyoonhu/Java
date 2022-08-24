package big_data.bit.exall;

//복소수를 모델링한 Complex 모델링
class Complex {
	private static double num1, num2 = 0.0;

	public Complex(double num1) {
		this.num1 = num1;
	}

	public Complex(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public static void print() {
		System.out.printf("%.1f + %.1fi\n", num1, num2);
	}
	
}

public class P166Ex06 {
	public static void main(String[] args) {
		Complex c1 = new Complex(2.0);
		c1.print();
		Complex c2 = new Complex(1.5, 2.5);
		c2.print();
	}
}
