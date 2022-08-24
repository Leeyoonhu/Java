package big_data.bit.ex04;

class Point {
	int x, y;

	void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void showPoint() {
		System.out.printf("(%d, %d)", this.x, this.y);
	}
}

class ColorPoint extends Point {
	String color;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	void showColorPoint() {
		System.out.printf("%s(%d, %d)", color, this.x, this.y);
	}
}

public class Exercise02 {
	public static void main(String[] args) {
		ColorPoint p2 = new ColorPoint();
		p2.set(3, 4);
		p2.setColor("red");
		p2.showColorPoint();
	}
}
