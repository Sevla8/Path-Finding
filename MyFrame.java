import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MainPanel mainPanel;
	public ControlPanel controlPanel;

	public MyFrame(MainPanel mainPanel, ControlPanel controlPanel) {
		this.setSize(1000, 1000);
		this.setLocation(0, 25);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("A*");
		this.setLayout(null);

		mainPanel.setOpaque(true);
		controlPanel.setOpaque(true);

		this.add(controlPanel);
		this.add(mainPanel);
	}

	public void run() {
		this.setVisible(true);
	}
}
