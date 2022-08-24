package big_data.bit.exall;

interface Human {
	static void echo() {
		System.out.println("야호!!!");
	}
	void eat();
	void print();
}

class Worker implements Human {
	
	public void print() {
		System.out.println("인간입니다.");
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("빵을 먹습니다.");
	}
}
// 같은 패키지에 Student 있으므로 01로 재지정
class Student01 implements Human{
	int i;
	Student01(int i){
		this.i = i;
	}
	public void print() {
		System.out.printf("%d세의 학생입니다.\n", i);
	}
	
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("도시락을 먹습니다.");
	}
}

public class P304Ex06 {
	public static void main(String[] args) {
		Human.echo();
		
		Student01 s = new Student01(20);
		s.print();
		s.eat();
		
		Human p = new Worker();
		p.print();
		p.eat();
	}
}
