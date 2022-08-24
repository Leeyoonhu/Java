package big_data.bit.ex05;

interface Movable {
	public void moveUp(); // y 감소
	public void moveDown(); // y 증가
	public void moveLeft(); // x 감소
	public void moveRight(); // x 증가
}

class MovablePoint implements Movable {
	int x, y;
	int xSpeed, ySpeed; // 변화량
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		this.x = x;
		this.y = y;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		
	}
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		System.out.println("포인트 위로 이동");
		this.y -= this.ySpeed;
	}
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		System.out.println("포인트 아래로 이동");
		this.y += this.ySpeed;
	}
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		System.out.println("포인트 왼쪽으로 이동");
		this.x -= this.xSpeed;
	}
	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		System.out.println("포인트 오른쪽로 이동");
		this.x += this.xSpeed;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("MovablePoint[x=%d, y=%d, xSpeed=%d, ySpeed=%d]", x, y, xSpeed, ySpeed);
	}
}

class MovableCircle implements Movable {
	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
		this.center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		System.out.println("원 위로 이동");
		center.y -= center.ySpeed;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		System.out.println("원 아래로 이동");
		center.y += center.ySpeed;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		System.out.println("원 왼쪽으로 이동");
		center.x -= center.xSpeed;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		System.out.println("원 오른쪽으로 이동");
		center.x += center.xSpeed;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("MovableCircle[center=%s, radius=%d", center.toString(), radius);
	}
}

public class Exercise04 {
	public static void main(String[] args) {
		MovablePoint mp = new MovablePoint(5, 6, 10, 15);
		System.out.println("포인트 이동 전");
		System.out.println(mp.toString());
		mp.moveLeft();
		System.out.println(mp.toString());
		mp.moveUp();
		System.out.println(mp.toString());
		
		MovableCircle mc = new MovableCircle(1, 2, 3, 4, 20);
		System.out.println("원 이동 전");
		System.out.println(mc.toString());
		mc.moveRight();
		System.out.println(mc.toString());
		mc.moveDown();
		System.out.println(mc.toString());
	}
}
