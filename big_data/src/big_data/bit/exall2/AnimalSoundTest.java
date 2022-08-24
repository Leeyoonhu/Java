package big_data.bit.exall2;

import java.util.ArrayList;
import java.util.List;

// P388Ex05

interface Animal {
	void sound();
}

class Dog implements Animal {
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("¸Û¸Û~~");
	}
}

class Cuckoo implements Animal {
	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("»µ²Ú»µ²Ú~~");
	}
}

public class AnimalSoundTest {
	// printSound() ¸Þ¼­µå
	static <T> void printSound(List<T> list) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i) instanceof Animal) {
				Animal a = (Animal)list.get(i);
				if(a instanceof Cuckoo) {
					Cuckoo c = (Cuckoo)a;
					c.sound();
				}
				if(a instanceof Dog) {
					Dog d = (Dog)a;
					d.sound();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Animal> aniList = new ArrayList<Animal>();
		aniList.add(new Dog());
		aniList.add(new Cuckoo());
		printSound(aniList);
		
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog());
		printSound(dogList);
	}
}
