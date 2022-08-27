package bit_commit_exercise.day05;
// 무한으로 실행하는 도서 관리 프로그램
import static utils.scan.scan;
public class Ex02 {
	public static void main(String[] args) {
		Book[] bArray = new Book[10];
		int i = 0;
		BREAK:
		while(true) {
			System.out.println("1.도서 정보 입력 | 2.도서 목록 보기 | 3.검색하기(제목) |"
					+ " 4.수량정보(여성작가수/보유도서수) | 5. 프로그램 종료");
			int menu = scan.nextInt();
			switch(menu) {
			case 1:
				System.out.println("title, author, email, gender, price, qty 입력>>");
				bArray[i] = new Book(scan.next(), new Author(scan.next(), scan.next(), scan.next()), scan.nextDouble(), scan.nextInt());
				i++;
				break;
			case 2:
				for(int j = 0; j < bArray.length; j++) {
					if(bArray[j] != null) {
						System.out.println(bArray[j]);
					}
					
				}
				break;
			case 3:
				System.out.print("제목을 입력하세요 -->> ");
				String title = scan.next();
				for(int j = 0; j < bArray.length; j++) {
					if(bArray[j] != null) {
						if(bArray[j].getTitle().equals(title)) {
						System.out.println(bArray[j]);
						}
					}
					
				}
				break;
			case 4:
				int female = 0; 
				int total = 0;
				for(int j = 0; j < bArray.length; j++) {
					if(bArray[j] != null) {
						if(bArray[j].getAuthor().getGender().equals("f")) {
							female ++;
						}
						total++;
					}
					
				}
				System.out.print(String.format("여성작가도서/총보유도서 : (%d/%d)\n", female, total));
				break;
			case 5:
				break BREAK;
			}
		}
	}
}
