package big_data.bit.ex05;

import java.text.DecimalFormat;

public class DecimalFormatEx {
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#,###.0");
		String result = df.format(1234567.89);
		System.out.println(result);
	}
}
