package big_data.bit.ex1;

public class While2Demo {
	public static void main(String[] args) {
		int sDan = 2;
		while (sDan < 10) {
			int eDan = 1;
			while (eDan < 10) {
				System.out.printf("%d\t", sDan * eDan);
				eDan ++;
			}
			System.out.println();
			sDan++;
		}
	}
}
