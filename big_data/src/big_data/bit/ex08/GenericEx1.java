package big_data.bit.ex08;

class Cup<T> {
	private T beverage;

	public T getBeverage() {
		return beverage;
	}

	public void setBeverage(T beverage) {
		this.beverage = beverage;
	}
	
}

class Beverage {
	
}

class Beer extends Beverage {
	
}

class Boricha extends Beverage {
	
}

public class GenericEx1 {
	public static void main(String[] args) {
		Cup<Beer> bCup = new Cup<Beer>();
		// 컵에 뭘 담을지 음료를 따를 때에 결정(메인 메서드 시작할 때에 무슨 음료 타입을 넣을지 결정)
		// == 객체를 생성 할 때 <T> 에 데이터 타입 결정
	}
}
