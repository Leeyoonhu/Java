package big_data.bit.exall;

class Vehicle {
	String color;
	int speed;
	
	public Vehicle(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}

	void show() {
		System.out.printf("색상 : %s, 속도 : %d\n", color, speed);
	}
}

class Car01 extends Vehicle {
	int displacement, gears;

	public Car01(String color, int speed, int displacement, int gears) {
		super(color, speed);
		this.displacement = displacement;
		this.gears = gears;
	}

	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.printf("색상 : %s, 속도 : %d, 배기량 : %d, 기어 :%d\n", super.color, super.speed, displacement, gears);
	}
}

public class P263Ex06 {
	public static void main(String[] args) {
		Car01 c = new Car01("파랑", 200, 1000, 5);
		c.show();
		System.out.println();
		
		Vehicle v = (Vehicle)c;
		v.show();
	}
}
