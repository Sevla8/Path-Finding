import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

public class Main {
	public static void main(String[] args) {

		ControlPanel controlPanel = new ControlPanel("barrier", "path", new Coord(0, 0), new Dimension(700, 100), Color.BLUE);
		MainPanel mainPanel = new MainPanel(500, 10, Color.GREEN, controlPanel);

		MyFrame frame = new MyFrame(mainPanel, controlPanel);
		frame.run();
	}
}
