package big_data.bit.exall2;

class MyDate {
	int year;
	int month;
	int day;
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
}

public class P386Ex01 {
	public static void main(String[] args) {
		MyDate d = null;
		d = new MyDate(2035, 12, 25);
		System.out.printf("%d³â %d¿ù %dÀÏ\n", d.year, d.month, d.day);
	}
}
