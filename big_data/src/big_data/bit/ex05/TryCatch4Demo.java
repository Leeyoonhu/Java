package big_data.bit.ex05;

class Reso implements AutoCloseable {
	void show() {
		System.out.println("자원 사용");
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("자원 닫기");
	}
	
}

public class TryCatch4Demo {
	public static void main(String[] args) {
		Reso r = null;
		try{
			r = new Reso();
			r.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외 처리");
		}
	}
	
}
