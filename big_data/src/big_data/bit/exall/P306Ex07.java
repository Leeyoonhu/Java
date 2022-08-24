package big_data.bit.exall;

interface Flyable {
	void speed();
	void height();
}

class Fly implements Flyable {
	@Override
	public void speed() {
		// TODO Auto-generated method stub
		System.out.println("속도");
	}
	@Override
	public void height() {
		// TODO Auto-generated method stub
		System.out.println("높이");
	}
}


public class P306Ex07 {
	public static void main(String[] args) {
		Flyable f = new Fly();
		f.speed();
		f.height();
	}
}
