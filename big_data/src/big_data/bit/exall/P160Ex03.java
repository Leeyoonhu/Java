package big_data.bit.exall;

// 양면출력이 가능한 Printer 클래스로 변경하고 접근자와 설정자 추가
// 양면출력여부 필드 private 선언
// 이 필드를 초기화하는 생성자와 외부에서 필드를 사용할수 있도록 접근자 설정자 추가\

class Printer {
	private int numOfPapers;
	private boolean duplex;
	
	public Printer(int numOfPapers, boolean duplex) {
		this.numOfPapers = numOfPapers;
		this.duplex = duplex;
	}
	
	public void print(int amount) {
		if(duplex == true) {
			System.out.printf("양면으로 %d장 출력했습니다. 현재 %d장 남아 있습니다.\n", amount/2 + 1, numOfPapers - (amount/2 + 1));
			numOfPapers -= (amount/2 + 1);
		}
		else {
			System.out.printf("단면으로 모두 출력하려면 용지가 %d매 부족합니다. %d장만 출력합니다.\n", amount - numOfPapers, numOfPapers);
		}
	}

	public void setDuplex(boolean duplex) {
		this.duplex = duplex;
	}
	
	
	
}

public class P160Ex03 {
	public static void main(String[] args) {
		Printer p = new Printer(20, true);
		p.print(25);
		p.setDuplex(false);
		p.print(10);
		
	}
}
