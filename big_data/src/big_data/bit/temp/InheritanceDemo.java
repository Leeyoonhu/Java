package big_data.bit.temp;

public class InheritanceDemo {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Ball b1 = new Ball("빨간색");
		
		System.out.println("==== 원의 정보 ====");
		c1.findRadius();
		c1.findArea();
		
		System.out.println();
		System.out.println("==== 공의 정보 ====");
		b1.findRadius();
		b1.findColor();
		b1.findArea();
		b1.findVolume();
	}
}
