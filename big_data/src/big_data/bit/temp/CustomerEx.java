package big_data.bit.temp;

public class CustomerEx {
	public static void main(String[] args) {
		Customer c = new VIPCustomer(); // 업캐스팅
		VIPCustomer v = (VIPCustomer)c; // 다운캐스팅
		v.getAgentID();
	}
}
