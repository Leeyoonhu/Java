package big_data.bit.ex08;

import java.util.HashSet;
import java.util.Set;

class Person01 {
	String name;
	int age;
	public Person01(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	// set은 중복이 없어야 하므로, 원래 중복을 검사하던 hashCode와 equals 재정의
	// 이름과 나이가 같을 경우 동일한 객체로 판단하고 중복을 제거하게 컴파일러에게 알려줘야한다
	// 중복 검사를 할 때, 두 객체의 hashCode()같은지 먼저 판단하고, 같은 경우에 equals()로 또한번 판단하기 때문에
	// hashCode()를 먼저 재정의 해줘야함
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode() + this.age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Person01) {
			Person01 p1 = (Person01)obj;
			// 이름이 같고, 나이가 같을 경우 중복으로 보고싶다
			return (p1.getName().equals(this.name) && p1.getAge()== this.age);
		}
		else {
			return false;
		}
	}
	
	
	
}

public class HashSetEx03 {
	public static void main(String[] args) {
		Set<Person01> pSet = new HashSet<Person01>();
		pSet.add(new Person01("conan", 10));
		pSet.add(new Person01("conan", 10));
		// 객체는 다른 공간에 생성(두 객체의 hashCode()가 다름)되기때문에 컴파일러가 중복이라고 판단을 못함 
		System.out.println("셋에 저장된 데이터의 수 : " + pSet.size());
	}
}
