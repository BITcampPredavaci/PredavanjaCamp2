import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	
	private static void firstPart(){
		int fullWidth = 400, fullHeight = 600;
		JFrame window = new JFrame("Basic components");

		JPanel container = new JPanel();

		// labels
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setForeground(Color.BLUE);
		nameLabel.setFont(new Font("Serif", Font.ITALIC, 13));

		JLabel emailLabel = new JLabel("Email");

		// textfields
		JTextField nameField = new JTextField(30);
		JTextField emailField = new JTextField(30);

		JTextArea terms = new JTextArea(10, 30);
		terms.setText("I here by solomly swear that I am up to no good. Oh and I accept the terms and conditions of Bitcamp.");
		terms.setLineWrap(true);
		terms.setEditable(false);

		// button
		JButton submit = new JButton("Submit");
		//submit.setEnabled(false);
		// checkbox
		JCheckBox cb = new JCheckBox("I accept the terms and conditions");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb.isSelected()) {
					String name = nameField.getText();
					String email = emailField.getText();
					System.out.println("Name: " + name + " Email: " + email);
				} else {
					JOptionPane error = new JOptionPane("You have to accept the terms and conditions", JOptionPane.ERROR_MESSAGE);
					error.createDialog(window, "Ha Ha!").setVisible(true);
					nameField.setText("");
					emailField.setText("");
					
					
				}
			}
		});

		// checkbox
		// JCheckBox cb = new JCheckBox("I accept the terms and conditions");
		// cb.addActionListener(new ActionListener(){
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// JCheckBox cb = (JCheckBox)e.getSource();
		// submit.setEnabled(cb.isSelected());
		// }
		// });

		container.add(nameLabel);
		container.add(nameField);
		container.add(emailLabel);
		container.add(emailField);
		container.add(terms);
		container.add(cb);
		container.add(submit);

		window.add(container);

		window.setSize(fullWidth, fullHeight);
		window.setVisible(true);
	}

	public static void main(String[] args) {
		JFrame window = new JFrame("Picker");
		
		ColorPicker cp = new ColorPicker(500, 500);
		window.add(cp);
		
		window.setSize(500, 500);
		window.setVisible(true);
	}

}
