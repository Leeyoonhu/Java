package big_data.bit.ex1;

class Sklass {
	static int i ;
	Sklass (){
		i++;
	}
}

class Oklass {
	int i ;
	Oklass (){
		i++;
	}
}

public class Temp9 {
	public static void main(String[] args) {
		new Sklass(); new Sklass(); Sklass s = new Sklass();
		new Oklass(); new Oklass(); Oklass o = new Oklass();
		System.out.printf("s.i = %d, o.i = %d", s.i, o.i);
	}
}
