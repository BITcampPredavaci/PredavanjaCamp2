import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 * Class implements a simple drawing panel
 * @author benjamin
 *
 */
public class PaintPanel extends JPanel{

	//the points to draw
	private PointArray points;
	
	//current active color
	private Color activeColor;
	
	//current size
	private int activeSize = 10;
	
	//possible color picks
	private static Color[] supportedColors = new Color[] { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE, Color.PINK };
	
	//possible size picks
	private static int[] supportedSize = new int[] { 10, 15, 20};
	
	
	public PaintPanel(int height, int width){
		super();
		
		points = new PointArray();
		setSize(width, height);
		setBackground(Color.WHITE);
		
		//add buttons for all the possible colors and add a listener
		for(int i = 0; i < supportedColors.length; i++){
			JButton color = new JButton("Pick");
			
			//an easy way to save the index of the color
			color.setName(Integer.toString(i));
			color.setForeground( supportedColors[i] );
			
			color.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton clicked = (JButton)e.getSource();
					
					//get the picked color index from the name
					String name = clicked.getName();
					int index = Integer.parseInt(name);
					
					//set the current color to the picked color
					activeColor = supportedColors[index];
				}				
			});
			
			add(color);
		}
		
		//add buttons for all the supported sizes
		for(int i = 0; i < supportedSize.length; i++){
			JButton size = new JButton(Integer.toString( supportedSize[i] ));
			size.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton clicked = (JButton)(e.getSource());
					
					//get the new size from the label
					String label = clicked.getText();
					int size = Integer.parseInt(label);
					
					//set the new active size
					activeSize = size;
				}	
			});
		}
		
		addMouseMotionListener(new MouseHandler());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//draw all the points added by the user
		for(int i = 0; i < points.getLength(); i++){
			Point p = points.elementAt(i);
			g.setColor(p.getColor());
			g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
		}
		
	}
	
	
	private class MouseHandler implements MouseMotionListener {

		/**
		 * While the user drags the mouse we want to add points to the array to be drawn later
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(), activeColor, activeSize);
			
			if(e.isShiftDown() == true){
				newPoint.setColor(Color.WHITE);
			}
			
			points.addPoint(newPoint);
			
			//ask for the panel to be redrawn
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
	
	
}
