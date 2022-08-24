package big_data.bit.ex03;

class Circle {
	double radius;
	
	double findArea() {
		return 3.14 * this.radius * this.radius;
	}

	public double getRadius() {
		return radius;
	}

	public Circle(double radius) {
		this.radius = radius;
	}
	
	public void showInfo() {
		System.out.printf("원의 넓이(반지름 : %.1f) = %.2f\n", radius, findArea());
	}
}

public class CircleArrayDemo {
	public static void main(String[] args) {
		Circle[] c = new Circle[5];
		for(int i = 0; i < c.length; i++) {
			c[i] = new Circle((double)i + 1);
		}
		for(int i = 0; i < c.length; i++) {
			c[i].showInfo();
		}
	}
}
