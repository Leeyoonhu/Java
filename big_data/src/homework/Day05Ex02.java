package homework;

import java.util.Scanner;

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
	public int getAnuualSalary() {
		return salary * 12;
	}
	public int raiseSalary(int percent) {
		return ((salary / 10) * percent);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Employee[id=%d, name=%s, salary=%d]의 연봉은 %d 월급 인상분은 %d", id, name, salary, getAnuualSalary(), raiseSalary(id));
	}
}

public class Day05Ex02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Employee[] empArray = new Employee[3];
		for(int i = 0; i < empArray.length; i++) {
			int id = scan.nextInt();
			String name = scan.next();
			int salary = scan.nextInt();
			empArray[i] = new Employee(id, name, salary);
		}
		for(int i = 0; i < empArray.length; i++) {
			System.out.println(empArray[i].toString());
		}
	}
}
