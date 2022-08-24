package big_data.bit.ex05;

class Rect {
	int width, height;

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rect) {
			Rect r = (Rect)obj;
			if(this.width * this.height == r.width * r.height) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
}

public class RectEx {
	public static void main(String[] args) {
		Rect r1 = new Rect(2,6);
		Rect r2 = new Rect(3,4);
		Rect r3 = new Rect(2,4);
		if(r1.equals(r2)) {
			System.out.println("r1과 r2가 각각 참조하는 두 사각형의 면적이 같음");
		}
		else {
			System.out.println("r1과 r2가 각각 참조하는 두 사각형의 면적이 다름");
		}
		if(r1.equals(r3)) {
			System.out.println("r1과 r2가 각각 참조하는 두 사각형의 면적이 같음");
		}
		else {
			System.out.println("r1과 r2가 각각 참조하는 두 사각형의 면적이 다름");
		}
	}
}
