package big_data.bit.ex03;

import java.util.Scanner;

class Goods{
	String name;
	int price;
	int numberOfStock;
	int sold;
	
}

// Goods 객체 배열 저장
// Goods 객체를 3개 입력받으면 이들을 모두 화면에 출력
public class GoodsEx {
	public static void main(String[] args) {
//		Goods shampoo = new Goods();
//		shampoo.name = "앨라스틴";
//		shampoo.price = 13000;
//		shampoo.numberOfStock = 30;
//		shampoo.sold = 50;
//		System.out.println("상품 이름 : " + shampoo.name);
//		System.out.println("상품 가격 : " + shampoo.price);
//		System.out.println("상품 재고 : " + shampoo.numberOfStock);
//		System.out.println("상품 판매량 : " + shampoo.sold);
		
		Scanner scan = new Scanner(System.in);
		Goods[] gArr = new Goods[3];
		for(int i = 0; i < gArr.length; i++) {
			gArr[i] = new Goods();
			gArr[i].name = scan.next();
			gArr[i].price = scan.nextInt();
			gArr[i].numberOfStock = scan.nextInt();
			gArr[i].sold = scan.nextInt();
		}
		System.out.printf("상품명 가격 재고량 판매량\n");
		for(int i = 0; i < gArr.length; i++) {
			System.out.print(gArr[i].name + " ");
			System.out.print(gArr[i].price + " ");
			System.out.print(gArr[i].numberOfStock + " ");
			System.out.print(gArr[i].sold + " ");
			System.out.println();
		}
	}
}
