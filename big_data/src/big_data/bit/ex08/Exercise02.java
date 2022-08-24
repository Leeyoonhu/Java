package big_data.bit.ex08;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Student {
	private String name;
	private int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s : %d", name, score);
	}
}

public class Exercise02 {
	public static void main(String[] args) {
		Map<Integer, Student> sMap = new HashMap<Integer, Student>();
		sMap.put(0, new Student("kid", 55));
		sMap.put(1, new Student("conan", 30));
		sMap.put(2, new Student("rose", 100));
		sMap.put(3, new Student("ran", 90));

		System.out.println("HashMap의 요소 개수 : " + sMap.size());
		for(int i = 0; i < sMap.size(); i++) {
			System.out.println(sMap.get(i).toString());
		}	
	}
}
