package ba.bitcamp.benjamin.paintcomponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorPicker extends JPanel {

	private int red, green, blue;
	private Color activeColor;
	private JButton preview;
	
	private static final int height = 0;

	// possible color picks
	private static Color[] supportedColors = new Color[] { Color.BLACK,
			Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
			Color.YELLOW };

	public ColorPicker(int width) {

		this.setSize(new Dimension(width, height));
		this.setLayout(new GridLayout(1, 3));
		this.add(predefinedColors());

		preview = new JButton();
		preview.setPreferredSize(new Dimension(width / 3, height));
		preview.setOpaque(true);
		preview.setBorder(BorderFactory.createRaisedBevelBorder());
		preview.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				activeColor = new Color(red, green, blue);
				preview.setBorder(BorderFactory.createLoweredBevelBorder());
			}
		});

		this.add(preview);
		this.add(sliders());

	}

	private JPanel predefinedColors() {
		JPanel predefinedColors = new JPanel();
		for (int i = 0; i < supportedColors.length; i++) {
			JButton color = new JButton();

			// an easy way to save the index of the color
			color.setName(Integer.toString(i));
			color.setBackground(supportedColors[i]);
			color.setBorder(BorderFactory.createRaisedBevelBorder());
			color.setOpaque(true);
			color.setPreferredSize(new Dimension(30, 30));

			final int j = i;
			color.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton source = (JButton) (e.getSource());
					JPanel parent = (JPanel) source.getParent();

					Component[] children = parent.getComponents();
					for (int i = 0; i < children.length; i++) {
						((JButton) children[i]).setBorder(BorderFactory
								.createRaisedBevelBorder());
					}
					
					activeColor = supportedColors[j];
					preview.setBackground(activeColor);
					color.setBorder(BorderFactory.createLoweredBevelBorder());
					preview.setBorder(BorderFactory.createRaisedBevelBorder());
				}
			});

			predefinedColors.add(color);
		}
		return predefinedColors;
	}

	private JPanel sliders() {
		JPanel sliders = new JPanel();
		// sliders
		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "red");

		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "green");

		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "blue");
		
		sliders.add(redSlider);
		sliders.add(greenSlider);
		sliders.add(blueSlider);
		
		return sliders;
	}

	private void initSlider(JSlider slider, String name) {
		slider.setName(name);
		slider.setToolTipText(name);
		slider.setValue(0);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);
		slider.setOrientation(JSlider.VERTICAL);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();

				// String name = changed.getName();
				switch (name) {
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

	private void updateButton() {
		preview.setBackground(new Color(red, green, blue));
		preview.setForeground(new Color(255 - red, 255 - green, 255 - blue));
	}

	public Color getActive() {
		return activeColor;
	}

}
