package ba.bitcamp.benjamin.paintcomponents;

import java.awt.BorderLayout;
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
 * 
 * @author benjamin
 *
 */
public class PaintPanel extends JPanel {

	// the points to draw
	private PointArray points;

	// current size
	private int activeSize = 10;
	private ColorPicker colorPicker;
	

	

	public PaintPanel(int height, int width) {
		super();

		colorPicker = new ColorPicker(width);
		this.setLayout(new BorderLayout());
		points = new PointArray();
		setSize(width, height);
		setBackground(Color.WHITE);

		// add buttons for all the possible colors and add a listener
		add(colorPicker, BorderLayout.NORTH);
		
		

		addMouseMotionListener(new MouseHandler());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw all the points added by the user
		for (int i = 0; i < points.getLength(); i++) {
			Point p = points.elementAt(i);
			g.setColor(p.getColor());

			g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());
		}

	}

	private class MouseHandler implements MouseMotionListener {

		/**
		 * While the user drags the mouse we want to add points to the array to
		 * be drawn later
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(), colorPicker.getActive(),
					activeSize);

			if (e.isShiftDown() == true) {
				newPoint.setColor(Color.WHITE);
			}

			points.addPoint(newPoint);

			// ask for the panel to be redrawn
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
		}

	}

}
