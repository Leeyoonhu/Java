package bit_commit_exercise.day04;
// 사원 3명의 아이디는 1~3
// 3명의 이름과 월급정보 배열에 저장할것
// 월급 인상률은 아이디 순으로 10~30%
import static utils.scan.scan;
class Employee {
	private int id;
	private String name;
	private int salary;
	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAnnualSalary() {
		return 12 * salary;
	}
	public int raiseSalary(int percent) {
		return (salary * percent) / 10; 
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Employee[id=%d, name=%s, salary=%d]의"
				+ "연봉은 %d 월급 인상분은 %d",id,name,salary,getAnnualSalary(),raiseSalary(id));
	}
	
}
public class Ex02 {
	public static void main(String[] args) {
		Employee[] eArray = new Employee[3];
		System.out.println("사원 정보 입력(id, name, salary)");
		for(int i = 0; i < eArray.length; i++) {
			eArray[i] = new Employee(scan.nextInt(), scan.next(), scan.nextInt());
		}
		for(int i = 0; i < eArray.length; i++) {
			System.out.println(eArray[i]);
		}
	}
}
