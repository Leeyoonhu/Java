package big_data.bit.exall;

// 동일 클래스명 있으므로 재생성
class Circle01 {
	// 반지름이 같은 객체를 동일하게 판단
	int radius;

	public Circle01(int radius) {
		this.radius = radius;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Circle01) {
			Circle01 c = (Circle01)obj;
			if(this.radius == c.radius) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
}


public class P345Ex01 {
	public static void main(String[] args) {
		Circle01 c1 = new Circle01(3);
		Circle01 c2 = new Circle01(3);
		
		if(c1.equals(c2)) {
			System.out.println("c1과 c2는 같다");
		}
		else {
			System.out.println("c1과 c2는 다르다");
		}
	}
}
