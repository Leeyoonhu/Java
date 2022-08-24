package big_data.bit.exersise;

class Circle {
	private double radius = 1.0;
	public Circle() {};
	
	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() { // pi pi r
		return (Math.PI * this.radius * this.radius);
	}
	
	public double getCircumference() { // 2 pi r
		return (2 * Math.PI * this.radius);
	}
	
	public String toString() {
//		return "Circle[radius=" + this.radius + "]";
		return String.format("Circle[radius = %2f]", radius);
		// printf 처럼 return하고싶다면 String.format("", ); 함수 사용
	}
}

public class CircleEx {
	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.printf("%s의 둘레는 %.2f, 면적은 %.2f\n", c.toString(), c.getCircumference(), c.getArea());
		c.setRadius(2.0);
		System.out.printf("%s의 둘레는 %.2f, 면적은 %.2f\n", c.toString(), c.getCircumference(), c.getArea());
	}
}
