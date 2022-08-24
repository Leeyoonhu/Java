package big_data.bit.exall;

class Hotel {
	int rNum = 0;
	String name = null;
	Hotel[] room = new Hotel[10]; // 호텔 객실 10개
	
	// room 배열 room[num]의 room[num].rNum = num ... room[num].name = name을 넣어주고
	void add(int num, String name) {
		room[num] = new Hotel();
		room[num].rNum = num;
		room[num].name = name;
	}
	
	// 조건을 주어서 배열중에 값있는것들 출력..
	void show() {
		for(int i = 0; i < room.length; i++) {
			try {
				if(room[i].rNum != 0 && room[i].name != null) {
					System.out.printf("%d번 방을 %s가 예약했습니다.\n", room[i].rNum, room[i].name);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				continue;
			}
		}
		
	}
}

public class P307Ex09 {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.add(5, "호돌이");
		hotel.add(7, "길동이");
		hotel.show();
	}
}
