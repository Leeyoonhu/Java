package big_data.bit.ex08;

import java.util.ArrayList;
import java.util.Iterator;

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Point(x=%d, y=%d)", x, y);
	}
}

public class ArrayListEx02 {
	public static void main(String[] args) {
		ArrayList<Point> pList = new ArrayList<Point>();
		pList.add(new Point(2, 3));
		pList.add(new Point(3, 4));
		pList.add(new Point(1, -6));
		for (int i = 0; i < pList.size(); i++) {
			System.out.println(pList.get(i).toString());
		}
		
		ArrayList<String> sList = new ArrayList<String>();
		sList.add("Hello");
		sList.add("Java");
		sList.add("Hi");
		System.out.println("index=====================");
		for(int i = 0; i < sList.size(); i++) {
			System.out.println(sList.get(i));
		}
		System.out.println("for each==================");
		for(String s : sList) {
			System.out.println(s);
		}
		System.out.println("Iterator==================");
		Iterator<String> ir = sList.iterator();
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
	}
}
