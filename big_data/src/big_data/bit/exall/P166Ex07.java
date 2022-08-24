package big_data.bit.exall;

// 골프채를 모델링한 GolfClub 클래스를 작성
class GolfClub {
	static int num;
	static String name = "아이번";
	public GolfClub() {
		num = 7;
	}
	public GolfClub(int num) {
		this.num = num;
	}
	public GolfClub(String name) {
		this.name = name;
	}
	
	static void print() {
		if(!name.equals("아이번")) {
			System.out.printf("%s입니다.", name);
		}
		else {
			System.out.printf("%d번 %s입니다.\n", num, name);
		}
	}
}

public class P166Ex07 {
	public static void main(String[] args) {
		GolfClub g1 = new GolfClub();
		g1.print();
		
		GolfClub g2 = new GolfClub(8);
		g2.print();
		
		GolfClub g3 = new GolfClub("퍼터");
		g3.print();
	}
}
