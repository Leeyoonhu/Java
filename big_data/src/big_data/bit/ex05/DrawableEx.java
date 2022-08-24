package big_data.bit.ex05;

interface Drawable{
	void draw();
}

class Rectangle implements Drawable {
	@Override // 어노테이션, 컴파일러가 체크하는 부가 정보
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그리다");
	}
}

class Circle implements Drawable {
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("원을 그리다");
	}
}

interface Printable {
	String print();
}

interface Showable {
	String show();
}

class A {
	A(){
		
	}
	
	A(String a, String b){
		System.out.printf("출력 : %s, 보여주기 : %s", a, b);
	}
}

class B extends A implements Printable, Showable {

	B(){
		super();
	}
	
	B(String a, String b) {
		super(a, b);
	}

	@Override
	public String show() {
		// TODO Auto-generated method stub
		return "쇼우";
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "프린터";
	}
	
}


public class DrawableEx {
	public static void main(String[] args) {
//		Drawable d = new Circle();
//		// 인터페이스는 레퍼런스 타입 변수로 쓸수있음
//		d.draw();
		B b1 = new B();
		B b2 = new B(b1.show(), b1.print());
		
	}
}
