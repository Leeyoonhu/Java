package homework;

interface GeomericObject {
	public double getPerimeter();
	public double getArea();
}

interface Resizeable {
	public void resize(int percent);
}

class Circle implements GeomericObject {
	protected double radius = 1.0;

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2 * 3.14 * radius;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 3.14 * radius * radius;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Circle[radius=%.1f]의 둘레는 %.1f, 면적은 %.1f", radius, getPerimeter(), getArea());
	}
}

class ResizeableCircle extends Circle implements Resizeable {
	public ResizeableCircle(double radius) {
		super.radius = radius;
	}
	public void resize(int percent) {
		System.out.printf("크기를 %d퍼센트 크게 변경 후\n", percent);
		super.radius += radius * ((double)percent/100);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("ResizeableCircle[%s", super.toString());
	}
	
}

public class Day06Ex02 {
	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println(c.toString());
		System.out.println("-----------------------------------------------------");
		ResizeableCircle rc = new ResizeableCircle(2.0);
		System.out.println(rc.toString());
		rc.resize(10);
		System.out.println(rc.toString());
	}
}
