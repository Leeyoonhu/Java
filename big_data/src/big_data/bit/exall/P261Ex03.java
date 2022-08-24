package big_data.bit.exall;

class Point { 
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Point(%d, %d)", this.x, this.y);
	}
}

class MovablePoint extends Point {
	private int xSpeed, ySpeed;

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public int getxSpeed() {
		return xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Point(%d, %d), Speed(%d, %d)", getX(), getY(), xSpeed, ySpeed);
	}
	
}

public class P261Ex03 {
	public static void main(String[] args) {
		Point p = new Point(10, 5);
		System.out.println(p.toString());
		MovablePoint mp = new MovablePoint(8, 8, 25, 19);
		System.out.println(mp.toString());
	}
}
