package homework;

class Rectangle {
	private double length = 1.0;
	private double width = 1.0;
	
	public Rectangle() {
		
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	public double getPerimeter() {
		return 2 * (width + length);
	}
	public double getArea() {
		return (width * length);
	}

	@Override
	public String toString() {
		return String.format("Rectangle[length=%.1f, width=%.1f]의 둘레는 %.1f, 면적은 %.1f", length, width, getPerimeter(), getArea());
	}
}

public class Day05Ex01 {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		System.out.println(r.toString());
		r.setLength(3.0);
		r.setWidth(4.0);
		System.out.println(r.toString());
	}
}
