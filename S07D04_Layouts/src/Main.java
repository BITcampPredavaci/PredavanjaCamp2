import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ba.bitcamp.benjamin.paintcomponents.PaintPanel;


public class Main {
	
	
	private static void partOne(){

		JFrame window = new JFrame("Layouts");
		JPanel container = new JPanel();
		
		container.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		//container.setLayout(new BorderLayout(20, 30));
		
		//container.setLayout(new GridLayout(2, 3));
		Random rand = new Random();
		JButton[] buttons = new JButton[5];
		for(int i = 0; i < buttons.length; i++){
			buttons[i] = new JButton("Button " + i);
			buttons[i].setOpaque(true);
			//buttons[i].setBorder(BorderFactory.createEmptyBorder(20, 0, 0 , 0));
			//buttons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			//buttons[i].setBorder(BorderFactory.createMatteBorder(5, 5, 10, 10, Color.BLACK));
			
			//buttons[i].setBorder(BorderFactory.createEtchedBorder());
			if(i % 2 == 0)
				buttons[i].setBorder(BorderFactory.createRaisedBevelBorder());
			else
				buttons[i].setBorder(BorderFactory.createLoweredBevelBorder());
			
			buttons[i].setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
			buttons[i].setPreferredSize(new Dimension(100, 100));
			container.add(buttons[i]);
		}
		
//		container.add(buttons[0], BorderLayout.EAST);
//		container.add(buttons[1], BorderLayout.WEST);
//		container.add(buttons[2], BorderLayout.NORTH);
//		container.add(buttons[3], BorderLayout.SOUTH);
//		container.add(buttons[4], BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		JFrame window = new JFrame("Layouts");
		
		PaintPanel pp = new PaintPanel(50, 600);
		
		window.add(pp);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(600, 800);
		window.setVisible(true);
		
		
	}

}
