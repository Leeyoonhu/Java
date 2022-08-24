package big_data.bit.exall;

abstract class Controller {
	boolean power;
	abstract void show();
	abstract String getName();
}

class TV extends Controller {
	
	TV(boolean b){
		super.power = b;
	}
	
	@Override
	void show() {
		// TODO Auto-generated method stub
		if(super.power == true) {
			System.out.printf("%s가 켜졌습니다\n", getName());
		}
		else {
			System.out.printf("%s가 꺼졌습니다\n", getName());
		}
	}
	@Override
	String getName() {
		// TODO Auto-generated method stub
		String name = "TV";
		return name;
	}
}

class Radio extends Controller {
	
	Radio(boolean b){
		super.power = b;
	}
	
	@Override
	void show() {
		// TODO Auto-generated method stub
		if(super.power == true) {
			System.out.printf("%s가 켜졌습니다\n", getName());
		}
		else {
			System.out.printf("%s가 꺼졌습니다\n", getName());
		}
	}
	@Override
	String getName() {
		String name = "라디오";
		return name;
	}
}

public class P304Ex05 {
	public static void main(String[] args) {
		Controller[] c = {new TV(false), new Radio(true)};
		
		for(Controller cTest : c) {
			cTest.show();
		}
	}
}
