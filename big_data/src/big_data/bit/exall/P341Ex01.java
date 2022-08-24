package big_data.bit.exall;
// 패키지에 동일이름 있으므로 Car02로 수정
class Car02 {
	private String model;
	public Car02() {
		// 모델을 초기화하는 코드
	}
	public Car02(String carName) {
		this.model = carName;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
}

public class P341Ex01 {
	public static void main(String[] args) {
		Car02 myCar = new Car02("그랜저");
		Car02 yourCar = new Car02("그랜저");
		// 객체 두개를 비교해서 모델이 다르게 출력
		if(myCar == yourCar) {
			System.out.printf("내 자동차는 [%s], 너 자동차는 [%s]로 모델이 같다\n", myCar.getModel(), yourCar.getModel());
		}
		else {
			System.out.printf("내 자동차는 [%s], 너 자동차는 [%s]로 모델이 다르다\n", myCar.getModel(), yourCar.getModel());
		}
	}
}
