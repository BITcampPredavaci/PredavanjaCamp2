package ba.bitamp.benjamin.programmingwithobjects;

public class Point {

	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	/**
	 * Method returns the distance between this point and another
	 * 
	 * using the distance formula 
	 * @param other the other point
	 * @return distance
	 */
	public double getDistance(Point other){
		
		int deltaX = this.x - other.x;
		int deltaY = this.y - other.y;
		
		deltaX *= deltaX;
		deltaY *= deltaY;
		
		return Math.sqrt( deltaX + deltaY );
		
	}
	
	
	public String toString(){
		return "( " + x + ",  " + y + " )";
	}
	
	
	public boolean equals(Point other){
		if(this.x == other.x && this.y == other.y)
			return true;
		
		return false;
	}
	
	
	
}
