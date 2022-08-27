package bit_commit_exercise.day06;

import java.util.ArrayList;
import java.util.List;

// 상속과 인터페이스를 사용해 사원 별 급여 정보 출력 프로그램 작성
// 리스트도 사용
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
		System.out.print(String.format("이름 : %s ", name));
	}
}
class PermanentWorker extends Worker {
	public int Salary;
	public PermanentWorker(String name, int salary) {
		super(name);
		Salary = salary;
	}
	@Override
	public int getPay() {
		// TODO Auto-generated method stub
		return Salary;
	}
	@Override
	public void showSalaryInfo() {
		// TODO Auto-generated method stub
		super.showName();
		System.out.println(String.format("-->> 급여 : %d", getPay()));
	}
}
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
		super.Salary += (int) (salesAmount * bonusRatio);
		salesAmount = 0; 
		bonusRatio = 0;
		return super.Salary;
	}
	@Override
	public void showSalaryInfo() {
		// TODO Auto-generated method stub
		super.showSalaryInfo();
	}
}

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
		return payPerHour * workTime;
	}
	@Override
	public void showSalaryInfo() {
		// TODO Auto-generated method stub
		super.showName();
		System.out.println(String.format("-->> 급여 : %d", getPay()));
	}
}
class ManagerService {
	private List<Worker> workers;

	public ManagerService() {
		workers = new ArrayList<Worker>();
	}
	public void addWorker(Worker worker) {
		workers.add(worker);
	}
	public void showAllSalaryInfo() {
		for(int i = 0; i < workers.size(); i++) {
			workers.get(i).showSalaryInfo();
		}
	}
	public void showSalaryInfo(String name) {
		for(int i = 0; i < workers.size(); i++) {
			if(workers.get(i).name.equals(name)) {
				workers.get(i).showSalaryInfo();
			}
		}
	}
	public void showTotalSalary() {
		int total = 0;
		for(int i = 0; i < workers.size(); i++) {
			total += workers.get(i).getPay();
		}
		System.out.println(String.format("모든 사원들의 급여 총액은 : %d원", total));
	}
}

public class Ex01 {
	public static void main(String[] args) {
		ManagerService ms = new ManagerService();
		ms.addWorker(new PermanentWorker("코난", 3000));
		ms.addWorker(new PermanentWorker("장미", 3500));
		ms.addWorker(new TemporaryWorker("알바1", 9, 100));
		ms.addWorker(new TemporaryWorker("알바2", 8, 70));
		ms.addWorker(new SalesWorker("판매왕", 1000, 200000, 0.01));
		ms.addWorker(new SalesWorker("판매신입", 1000, 50000, 0.01));
		ms.showAllSalaryInfo();
		ms.showTotalSalary();
		
	}
}
