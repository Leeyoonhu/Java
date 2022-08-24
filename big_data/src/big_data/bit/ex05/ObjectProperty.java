package big_data.bit.ex05;

class Point {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return String.format("Point(%d, %d)", x, y);
	}
	

	public boolean equals(Point p) {
		if(this.x == p.x && this.y == p.y) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

public class ObjectProperty {
	public static void main(String[] args) {
		Point a = new Point(2,3);
		System.out.println(a.getClass().getName());
		System.out.println(a.hashCode());	// 10진수로 표현된 주소값
		System.out.println(a.toString());	// 16진수로 표현된 주소값
		System.out.println(a);
		System.out.println("==== 구분선 ====");
		Point b = new Point(2,3);
		Point c = a;
		if(a==c) {
			System.out.println("a==c");
		}
		if(b==c) {
			System.out.println("b==c");
		}
		System.out.println("==== 구분선 ====");
		if(b.equals(c)==true) {
			System.out.println("Point b와 c의 x,y 좌표는 같습니다.");
		};
	}
}
