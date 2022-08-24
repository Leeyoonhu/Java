package big_data.bit.ex04;

class Circle01 {
	int radius;	// 인스턴스 멤버, new 생성자로 호출했을때 인스턴스(객체) 마다 별도로 생성
	String color;
	static int numberOfCircles; // 정적멤버, 클래스 멤버
	// 모든 인스턴스(객체)에서 동일한 값 공유
	// 별도의 static 메모리 공간에 생성되며, new 생성자로 생성하기전에 이미 생성되어 있음
	// 클래스이름.정적변수 or 클래스이름.정적함수() 로 사용가능
	// 대표적인 static을 잘쓰는건 Math함수
	public Circle01(int radius, String color) {
		this.radius = radius;
		this.color = color;
	}
}

public class CircleEx01 {
	
	void print() {
		System.out.println("Static 연습");
	}
	// static 메서드안에는 static 멤버만 사용가능
	// 만약 static 안에 인스턴스 맴버를 사용하고싶다면, new 를 사용하여 객체를 생성하고 
	// 해당 객체를 참조할 변수에서 맴버호출하면됨
	
	public static void main(String[] args) {
//		Circle c1 = new Circle(100, "red");
//		Circle c2 = new Circle(50, "yellow");
//		Circle.numberOfCircles++;
//		System.out.println(Circle.numberOfCircles);
//		c1.numberOfCircles++;
//		c2.numberOfCircles++;
//		System.out.println(Circle.numberOfCircles);
//		
//		System.out.println(Math.PI);
		
	}
}
