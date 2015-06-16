package ba.bitamp.benjamin.programmingwithobjects;

public class Circle {
	
	private Point center;
	private int radius;
	
	public Circle(int x, int y, int radius){
		this.center = new Point(x,y);
		this.radius = radius;
	}


	public boolean equals(Circle other) {
		if( this.center.equals(other.center) && radius == radius   )
			return true;
		return false;
	}

	@Override
	public String toString() {
		return String.format("Center: %s, Radius: %d", center, radius);
	}
	
	public boolean intersect(Circle other){
		if( this.radius + other.radius < this.center.getDistance(other.center)){
			return false;
		} else {
			return true;
		}
	}
	
	
	
}
