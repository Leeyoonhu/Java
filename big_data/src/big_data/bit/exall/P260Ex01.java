package big_data.bit.exall;

// Circle과 상속받는 ColoredCircle 작성
class Circle {
	int radius;
	public Circle(int radius) {
		this.radius = radius;
	}
	void show() {
		System.out.println("반지름이 " + radius + "인 원이다.");
	}
}

class ColoredCircle extends Circle {
	String color;
	public ColoredCircle(int radius, String color) {
		super(radius);
		this.color = color;
	}
	@Override
	void show() {
		System.out.println("반지름이 " + radius + "인 " + color + " 원이다.");
	}
}

public class P260Ex01 {
	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		c1.show();
		ColoredCircle c2 = new ColoredCircle(10, "빨간색");
		c2.show();
	}
}
