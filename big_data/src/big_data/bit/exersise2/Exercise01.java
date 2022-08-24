package big_data.bit.exersise2;

abstract class Shape {
	public abstract double calArea();
}

class Circle extends Shape {
	public double radius;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double calArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}
	
}

class Rectangle extends Shape {
	public double width, height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double calArea() {
		// TODO Auto-generated method stub
		return width * height;
	}
}

public class Exercise01 {
	public static void main(String[] args) {
		Shape[] s = new Shape[3];
		s[0] = new Circle(5.0);
		s[1] = new Rectangle(3, 4);
		s[2] = new Circle(1);
		double sum = 0.0;
		for(int i = 0; i < s.length; i++) {
			sum += s[i].calArea();
		}
		System.out.print("면적의 합:" + sum);
		
	}
}
