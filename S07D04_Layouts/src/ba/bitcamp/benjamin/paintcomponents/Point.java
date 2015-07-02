package ba.bitcamp.benjamin.paintcomponents;
import java.awt.Color;

/**
 * Represents a single point to be drawn
 * Contains the point location(x, y), size and color
 * @author benjamin
 *
 */
public class Point {
	
	private int x;
	private int y;
	private int size;
	private Color color;
	private boolean isLast;
	
	public Point(int x, int y, Color color, int size){
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.isLast = false;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getSize(){
		return size;
	}
	
	public void setIsLast(boolean isLast){
		this.isLast = isLast;
	}
	
	public boolean getIsLast(){
		return isLast;
	}
	

}
