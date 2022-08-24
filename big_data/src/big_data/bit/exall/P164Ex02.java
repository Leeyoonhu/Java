package big_data.bit.exall;

// Ex01 에서 Triangle클래스에 두 삼각형 넓이가 동일한지 비교하는 isSameArea()메서드 추가하기

public class P164Ex02 {
	public static void main(String[] args) {
		Triangle t1 = new Triangle(10.0, 5.0);
		Triangle t2 = new Triangle(5.0, 10.0);
		Triangle t3 = new Triangle(8.0, 8.0);
		
		System.out.println(t1.isSameArea(t2));
		System.out.println(t1.isSameArea(t3));
	}
}
