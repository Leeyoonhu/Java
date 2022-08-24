package big_data.bit.exersise;

class Person {
	private String name;
	private String addr;
	
	public Person(String name, String addr) {
		this.name = name;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String toString() {
		return String.format("Person[name=%s, address=%s]", this.name, this.addr);
	}
}

class Student extends Person{
	private String program;
	private int year;
	private double fee;
	public Student(String name, String addr, String program, int year, double fee) {
		super(name, addr);
		this.program = program;
		this.year = year;
		this.fee = fee;
	}
	public String getProgram() {
		return program;
	}
	public int getYear() {
		return year;
	}
	public double getFee() {
		return fee;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
//		return String.format("Student[Person[name=%s, address=%s], program=%s, year=%d, fee=%.1f]", getName(), getAddr(), program, year, fee);
		return String.format("Student%s, program=%s, year=%d, fee=%.1f]", super.toString(), program, year, fee);
	// 자식 클래스에서 부모 클래스 맴버에 접근할 때 -->> super.맴버(필드/메서드);
	}
}

class Staff extends Person {
	private String school;
	private double pay;
	public Staff(String name, String addr, String school, double pay) {
		super(name, addr);
		this.school = school;
		this.pay = pay;
	}
	public String getSchool() {
		return school;
	}
	public double getPay() {
		return pay;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Staff[Person[name=%s, address=%s], school=%s, pay=%.1f]", getName(), getAddr(), school, pay);
	}
}

public class PersonEx {
	public static void main(String[] args) {
		Person p = new Person("코난", "미란이네");
		System.out.println(p.toString());
		Student stu1 = new Student("장미", "브라운 박사님댁", "생명과학", 1, 25000.0);
		System.out.println(stu1.toString());
		Student stu2 = new Student("미란", "미란이네", "태권도", 3, 3000.0);
		System.out.println(stu2.toString());
		Staff staff1 = new Staff("유명한", "미란이네", "청솔대학", 20.0);
		System.out.println(staff1.toString());
		
	}
}
