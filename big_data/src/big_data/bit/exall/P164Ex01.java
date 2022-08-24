package big_data.bit.exall;
// 삼각형을 나타내는 triangle
// 속성은 실수값의 밑변, 높이
// 동작은 넓이구하기, 접근자, 생성자.

class Triangle {
	double width, height;
	
	public Triangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	double findArea(){
		return (width * height) / 2;
	}

	public boolean isSameArea(Triangle t2) {
		if(this.findArea() == t2.findArea()) {
			return true;
		}
		else {
			return false;
		}
	}

}

public class P164Ex01 {
	public static void main(String[] args) {
		Triangle t = new Triangle(10.0, 5.0);
		System.out.println(t.findArea());
		
	}
}
