package big_data.bit.exall;
// 생성된 모든 자동차와 빨간색 자동차의 개수를 출력하는 Car클래스

class Car {
	String name;
	static int count = 0, redCount = 0;
	public Car(String name) {
		this.name = name;
		count++;
		if("red".equalsIgnoreCase(name)) {
			redCount++;
		}
	}
	
	static int getNumOfCar() {
		return count;
	}
	
	static int getNumOfRedCar() {
		return redCount;
	}
}

public class P165Ex04 {
	public static void main(String[] args) {
		Car c1 = new Car("red");
		Car c2 = new Car("blue");
		Car c3 = new Car("RED");
		
		System.out.printf("자동차 수 : %d, 빨간색 자동차 수 : %d", 
				Car.getNumOfCar(), Car.getNumOfRedCar());
	}
}
