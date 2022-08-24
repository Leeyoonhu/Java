package big_data.bit.ex04;

// 환율 계산기
class CurrencyConverter {
	private static double rate; //원화 환율
	
	public static double toDollar(double won) { // 원화 달러 변환
		return won / rate;	
	}
	
	public static double toKWR(double dollar) { // 달러 원화 변환
		return dollar * rate;
	}
	
	public static void setRate(double r) {	// 환율 대입
		rate = r;
	}
}

public class CurrencyConverterEx {	
	public static void main(String[] args) {
		CurrencyConverter.setRate(1308.40);
		System.out.printf("백만원은\t %.2f달러입니다.\n", CurrencyConverter.toDollar(1000000));
		System.out.printf("백달러는\t%.2f원입니다.\n", CurrencyConverter.toKWR(100));
	}
}
