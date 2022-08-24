package big_data.bit.exall;
//클래스명 동일 재정의
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

// 클래스 이름 동일하므로 재생성
class Car04 {
	private String model;
	public Car04() {
		// 모델을 초기화하는 코드
	}
	public Car04(String carName) {
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
		if(obj instanceof Car04) {
			Car04 cTest = (Car04)obj;
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

public class P342Ex03 {
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
		
		System.out.println("===== 분할 출력 하기 =====");	
		// 토큰으로 분할해서, while문 사용해서 출력할 것
		StringTokenizer st = new StringTokenizer(showAll, ",: =[]()");
		while(st.countTokens() > 0) {
			System.out.println(st.nextToken());
		}
	}

	
}
