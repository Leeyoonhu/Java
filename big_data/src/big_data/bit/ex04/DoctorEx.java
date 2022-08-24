package big_data.bit.ex04;

import javax.sql.rowset.serial.SerialArray;

class Doctor {
	public void job() {
		System.out.println("진단과 치료를 함");
	}
}

class Surgeon extends Doctor {

//	public void job() {
//		System.out.println("오버라이딩임");
//	}
	
	
	public void job(String s) {	//오버로딩
		System.out.println(s + "를 수술함");
	}
	
}

public class DoctorEx {
	public static void main(String[] args) {
		Doctor d = new Doctor();
//		d.job();
		
		Surgeon s = new Surgeon();
		s.job();
		s.job("뇌");
	}
}
