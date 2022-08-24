package big_data.bit.exall2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Person {
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("Person[%s, %d] ", getName(), getAge());
	}
}

public class P469Ex02 {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		set.add(new Person("김열공", 20));
		set.add(new Person("최고봉", 56));
		set.add(new Person("우등생", 16));
		set.add(new Person("나자바", 35));
		
		for(Person p : set) {
			System.out.println(p.getName() + " : " + p.getAge());
		}
		
		Iterator ir = set.iterator();
		while(ir.hasNext()) {
			System.out.print(ir.next());
		}
	}
}
