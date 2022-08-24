package big_data.bit.exall2;

class Box <T> {
	T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
	
}

public class P389Ex07 {
	public static void main(String[] args) {
		Box<Integer> i = new Box<Integer>();
		i.set(new Integer(100));
		System.out.println(i.get());
		
		Box<String> s = new Box<String>();
		s.set("만능이네!");
		System.out.println(s.get());
	}
}
