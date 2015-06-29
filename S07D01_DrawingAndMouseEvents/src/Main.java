import javax.swing.JFrame;


public class Main {

	
	public static void main(String[] args) {
		
		JFrame window = new JFrame("Out little program");
		PaintPanel dp = new PaintPanel(500, 500);
		
		window.add(dp);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500, 500);
		window.setVisible(true);		
		
		
		
	}
	
}
