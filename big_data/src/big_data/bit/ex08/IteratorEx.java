package big_data.bit.ex08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorEx {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.add("다람쥐");
		c.add("개구리");
		c.add("나비");
		Iterator<String> ir = c.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next() + "-");
		}
		
		while(ir.hasNext()) {
			System.out.print(ir.next() + "+");
		}
		if(ir.hasNext() == false) {
			System.out.println();
		}
		
		ir = c.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next() + "+");
		}
	}
}
