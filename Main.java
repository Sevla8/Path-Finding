import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1000, 1000);
		frame.setLocation(0, 25);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("A*");
		frame.setLayout(null);


		ControlPanel controlPanel = new ControlPanel("obstacle", "chemin");

		MainPanel mainPanel = new MainPanel(50, 70, controlPanel);
		
		controlPanel.setOpaque(true);
		mainPanel.setOpaque(true);

		frame.add(controlPanel);
		frame.add(mainPanel);

		frame.setVisible(true);
	}
}
