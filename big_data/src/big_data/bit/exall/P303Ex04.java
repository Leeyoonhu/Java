package big_data.bit.exall;

interface Talkable {
	void talk();
}

class Korean implements Talkable {
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요!");
	}
}

class American implements Talkable {
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
	}
}

public class P303Ex04 {
	
	static void speak(Talkable t) {
		t.talk();
	}	
	
	public static void main(String[] args) {
		speak(new Korean());
		speak(new American());
	}
}
