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
			System.out.println("���ܸ� ���θ޼��忡 ���ѱ�� ������~ �װ� ����");
		}
	}
	
	static void casting(Shape s) {
		Circle c = (Circle)s;
	}
}
