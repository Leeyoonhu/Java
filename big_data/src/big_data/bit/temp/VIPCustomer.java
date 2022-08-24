package big_data.bit.temp;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	public VIPCustomer() {
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		System.out.println("VIPCustomer() 디폴트 생성자 호출");
	}
	
	public int getAgentID() {
		return agentID;
	}
	
}
