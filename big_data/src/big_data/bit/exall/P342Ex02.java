package big_data.bit.exall;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// 클래스 이름 동일하므로 재생성
class Car03 {
	private String model;
	public Car03() {
		// 모델을 초기화하는 코드
	}
	public Car03(String carName) {
		this.model = carName;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override // equals 오버라이딩 할것
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Car03) {
			Car03 cTest = (Car03)obj;
			if(cTest.model.equals(obj)) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
}

// MessageFormat, SimpleDateFormat 클래스를 사용하여 오늘날짜, 자동차모델, 운전자 출력하는 코드 추가
public class P342Ex02 {
	public static void main(String[] args) {
		Car02 myCar = new Car02("그랜저");
		Car02 yourCar = new Car02("그랜저");
		if(myCar.getModel().equals(yourCar.getModel()) == true) {
			System.out.println(String.format("자동차 모델이 둘 다 [%s]로 동일하다", myCar.getModel()));
		}
		else {
			System.out.println(String.format("자동차 모델이 동일하지 않다", myCar.getModel()));
		}
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("MM-dd-yyyy"); //출력 형식
		String nowTime = sf.format(d); // 현재 년-월-일을 형식에 맞게 저장
		String carOperator = "운전자(홍길동)";
		String showAll = MessageFormat.format("날짜: {0}, 자동차 모델 =[{1}], {2}", nowTime, myCar.getModel(), carOperator);
		// 패턴순서에 맞게 값들 배치
		System.out.println(showAll);
	}
}
