package big_data.bit.exall;

// 회원 관리 Member 클래스 만들기
// 정보는 이름, 아이디, 암호, 나이
// 외부 객체는 회원 정보에 직접 접근 x, 오직 접근자와 생성자로만 가능
// 모든 정보를 사용해 객체생성가능한 생성자도있음

class Member {
	private String name;
	private int id, password, age;
	
	public Member(String name, int id, int passWord, int age) {
		this.name = name;
		this.id = id;
		this.password = passWord;
		this.age = age;
	}
	
	public void showInfo() {
		System.out.printf("이름 : %s 아이디 : %d 비밀번호 : %d 나이 : %d", name, id, password, age);
	}
}

public class P164Ex03 {
	public static void main(String[] args) {
		Member memberLee = new Member("홍길동", 1001, 1234, 20);
		memberLee.showInfo();
	}
}
