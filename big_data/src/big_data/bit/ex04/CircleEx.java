package big_data.bit.ex04;

class Circle {
	private double radius;
	// private 변수를 사용할 수 있도록 접근자 설정자 지정
	
	public double getRadius() { // 접근자(getter)
		return radius;
	}

	public void setRadius(double radius) { // 설정자(setter)
		this.radius = radius;
	}
	
	double findArea() {
		return 3.14 * radius * radius; // 원의 넓이 계산
	}
	
	void show(double r, double area) { // 반지름과 넓이를 입력받아 출력
		System.out.printf("반지름 : %.1f, 넓이 : %.1f\n", r, area);
	}
}

public class CircleEx {
	public static void main(String[] args) {
		Circle myCircle = new Circle();
		myCircle.setRadius(10.0);
		myCircle.show(myCircle.getRadius(), myCircle.findArea());
	}
	
}
