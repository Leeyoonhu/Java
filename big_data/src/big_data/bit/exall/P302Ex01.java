package big_data.bit.exall;

abstract class Abstract {
	int i;
	abstract void show();
	
	Abstract(int i){
		this.i = i;
	}
}

class Concrete extends Abstract {
	int j;
	Concrete(int i, int j) {
		super(i);
		this.j = j;
		// TODO Auto-generated constructor stub
	}
	@Override
	void show() {
		// TODO Auto-generated method stub
		System.out.printf("i = %d, j = %d", super.i, j);
	}
}

public class P302Ex01 {
	public static void main(String[] args) {
		Concrete c = new Concrete(100, 50);
		c.show();
	}
}
