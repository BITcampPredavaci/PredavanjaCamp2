import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ColorPicker extends JPanel {
	
	private int red;
	private int green;
	private int blue;
	private JButton click;
	
	public ColorPicker(int width, int height){
		
		initButton(width, height);
		
		int sliderHeight = height/7;
		Dimension sliderDimension = new Dimension(width-50, sliderHeight);
		
		//sliders
		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "red", sliderDimension);
		
		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "green", sliderDimension);
		
		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "blue", sliderDimension);
		
		//labels
		JLabel redLabel = new JLabel("Red");
		JLabel greenLabel = new JLabel("Green");
		JLabel blueLabel = new JLabel("Blue");
		
		add(click);
		add(redLabel);
		add(redSlider);
		add(greenLabel);
		add(greenSlider);
		add(blueLabel);
		add(blueSlider);
	}
	
	private void initSlider(JSlider slider, String name, Dimension d){
		slider.setName(name);
		slider.setPreferredSize(d);
		slider.setValue(0);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider)e.getSource();
				
				//String name = changed.getName();
				switch(name){
				case "red":
					red = changed.getValue();
					break;
				case "green":
					green = changed.getValue();
					break;
				case "blue":
					blue = changed.getValue();
					break;
				}
				updateButton();
			}
		});
	}
	
	private void updateButton(){
		click.setBackground(new Color(red, green, blue));
		click.setForeground(new Color(255-red, 255-green, 255-blue));
	}
	
	private void initButton(int width, int height){
		click  = new JButton("Click me");
		click.setPreferredSize(new Dimension(width, height/2));
		click.setOpaque(true);
		click.setBorderPainted(false);
		click.setFont(new Font("SansSerif", Font.BOLD, 26));
		click.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Clipboard clip = 
						Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				String copy = String.format("%d,%d,%d", red, green, blue);
				clip.setContents(new StringSelection(copy), null);
			}
		});
		updateButton();
	}

}
