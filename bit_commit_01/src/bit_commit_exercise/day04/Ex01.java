package bit_commit_exercise.day04;
// 길이와 높이가 주어지면 둘레와 면적을 구해주는 프로그램 작성
// Rectangle 클래스를 주어진 조건으로 만들 것
import static utils.scan.scan;;
class Rectangle {
	private double width = 1.0;
	private double height = 1.0;
	public Rectangle() {}
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getArea() {
		return width * height;
	}
	public double getPerimeter() {
		return (2 * width) + (2 * height);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Rectangle[width=%.1f, height=%.1f의 둘레는"
				+ " %.1f, 면적은 %.1f", width, height, getPerimeter(), getArea());
	}

}

public class Ex01 {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		System.out.println(r1.toString());
		Rectangle r2 = new Rectangle(3.0, 4.0);
		System.out.println(r2.toString());
	}
}
