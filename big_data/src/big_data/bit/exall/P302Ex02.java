package big_data.bit.exall;

interface Edible {
	void eat();
}

interface Sweetable {
	void sweet();
}

interface Delicious extends Edible, Sweetable {
	// 두 인터페이스를 하나로 통합한 interface Delicious 작성
}

public class P302Ex02 {
	
}
