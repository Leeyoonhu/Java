package big_data.bit.exall2;

class Shape {
	
}

class Rectangle extends Shape {
	
}

class Circle extends Shape {
	
}

public class P386Ex02 {
	public static void main(String[] args) throws ClassCastException {
		Rectangle r = new Rectangle();
		try {
			casting(r);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외를 메인메서드에 떠넘긴놈 누구냐~ 그게 나야");
		}
	}
	
	static void casting(Shape s) {
		Circle c = (Circle)s;
	}
}
