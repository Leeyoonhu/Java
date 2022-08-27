package bit_commit_exercise.day05;
// 상속과 인터페이스
interface GeomericObject {
	public double getPerimeter();
	public double getArea();
}
interface Resizeable {
	public void resize(int percent);
}
class Circle implements GeomericObject {
	protected double radius = 1.0;
	
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radius;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (Math.PI * Math.pow(radius, 2));
	}
	@Override
	public String toString() {
		return String.format("Circle [radius=%.1f]의 둘레는 %.1f, 면적은 %.1f", radius, getPerimeter(), getArea());
	}
}
class ResizeCircle extends Circle implements Resizeable {
	public ResizeCircle(double radius) {
		super(radius);
	}
	public void resize(int percent) {
		System.out.println(String.format("크기를 %d퍼센트 크게 변경후", percent));
		super.radius += (super.radius * ((double)percent / 100));
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return String.format("ResizeCircle [%s]", super.toString());
	}
}

public class Ex03 {
	public static void main(String[] args) {
		Circle c = new Circle(1.0);
		System.out.println(c);
		System.out.println("=====================================================");
		ResizeCircle rc = new ResizeCircle(2.0);
		System.out.println(rc);
		rc.resize(10);
	}
}
