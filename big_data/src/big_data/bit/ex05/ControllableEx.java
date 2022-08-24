package big_data.bit.ex05;

interface Controllable {
	default void repair() {
		System.out.println("장비를 수리한다");
	}
	
	static void reset() {
		System.out.println("장비를 초기화 한다.");
	}
	
	private void show(String s) {
		System.out.println(s);
	}

	void turnOn();
	void turnOff();
}

interface RemoteControllable extends Controllable {
	void remoteOn();
	void remoteOff();
}

class TV implements Controllable {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("티비를 켬");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("티비를 끔");
	}
	
}

class Computer implements Controllable {
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터를 끔");
	}@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("컴퓨터를 켬");
	}
}
public class ControllableEx {
	public static void main(String[] args) {
		TV tv = new TV();
		tv.repair();
		Controllable.reset();
		tv.turnOn();
		tv.turnOff();
		System.out.println("==== 구분선 ====");
		Controllable controll = new Computer();
		controll.repair();
		controll.turnOn();
		controll.turnOff();
		System.out.println("==== 구분선 ====");
		Controllable controll2 = new Controllable() {
			@Override
			public void turnOn() {
				// TODO Auto-generated method stub
				System.out.println("컨트롤2 켬");
			}
			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				System.out.println("컨트롤2 끔");
			}
			// 원래는 클래스를 정의하고 객체를 만드는게 맞음
			// 익명 객체는 일시적으로 클래스 객체가만들어진거
		};
	}
}
