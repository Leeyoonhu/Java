package big_data.bit.ex03;

class Circle02 {
	double radius;
	double findArea() {
		return 3.14 * radius * radius; // 원의 넓이 계산
	}
	
	void show(double r, double area) { // 반지름과 넓이를 입력받아 출력
		System.out.printf("반지름 : %.1f, 넓이 : %.1f\n", r, area);
	}
}

public class CircleDemo {
//	public static void main(String[] args) {
//		Circle myCircle = new Circle();
//		myCircle.radius = 10;
//		myCircle.show(myCircle.radius, myCircle.findArea());
//	}
}
