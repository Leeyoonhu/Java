package homework2;

import java.util.ArrayList;
import java.util.List;

interface Employee {
	public void showName();
	public int getPay();
	public void showSalaryInfo();
}

abstract class Worker implements Employee {
	protected String name;

	public Worker(String name) {
		this.name = name;
	}
	public void showName() {
		
	}
}

class PermanentWorker extends Worker {
	public int salary;

	public PermanentWorker(String name, int salary) {
		super(name);
		this.salary = salary;
	}
	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return this.salary;
	}
	@Override
	public void showSalaryInfo() {
		// TODO Auto-generated method stub
		System.out.printf("이름 : %s -->> 급여 : %d\n", super.name, getPay());
	}
}
//세일즈 워커는 보너스 비율에 비례해 추가금도 받지만, 판매량과 관계가있음

class SalesWorker extends PermanentWorker {
	public int salesAmount;
	public double bonusRatio;
	public SalesWorker(String name, int salary, int salesAmount, double bonusRatio) {
		super(name, salary);
		this.salesAmount = salesAmount;
		this.bonusRatio = bonusRatio;
	}
	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return super.salary + (int)(salesAmount * bonusRatio);
	}
	@Override
	public void showSalaryInfo() {
		// TODO Auto-generated method stub
		System.out.printf("이름 : %s -->> 급여 : %d\n", super.name, getPay());
	}	
}
//템퍼리워커는 시간 * 시간당 급여
class TemporaryWorker extends Worker {
	public int payPerHour;
	public int workTime;
	public TemporaryWorker(String name, int payPerHour, int workTime) {
		super(name);
		this.payPerHour = payPerHour;
		this.workTime = workTime;
	}
	
	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return workTime * payPerHour;
	}
	
	@Override
	public void showSalaryInfo() {
		// TODO Auto-generated method stub
		System.out.printf("이름 : %s -->> 급여 : %d\n", super.name, getPay());
	}
}

class ManagerService {
	private List<Worker> workers;
	
	public ManagerService() { // 리스트 생성
		workers = new ArrayList<Worker>();
	}
	
	public void addWorker(Worker worker) {
		workers.add(worker);
	}
	
	public void showAllSalaryInfo() {
		for(Worker w : workers) {
			w.showSalaryInfo();
		}
	}
	
	public void showSalaryInfo(String name) {
		
	}
	
	public void showTotalSalary() {
		int totalMoney = 0;
		for(Worker w : workers) {
			totalMoney += w.getPay();
		}
		System.out.println("모든 사원들의 급여 총액은 : " + totalMoney + "원");
	}
}

public class EmployeeManager {
	public static void main(String[] args) {
		ManagerService manager = new ManagerService();
		manager.addWorker(new PermanentWorker("코난", 3000));
		manager.addWorker(new PermanentWorker("장미", 3500));
		manager.addWorker(new TemporaryWorker("알바1", 9, 100));
		manager.addWorker(new TemporaryWorker("알바2", 8, 70));
		manager.addWorker(new SalesWorker("판매왕", 1000, 200000, 0.01));
		manager.addWorker(new SalesWorker("판매신입", 1000, 50000, 0.01));
		manager.showAllSalaryInfo();
		manager.showTotalSalary();
		
	}
}
