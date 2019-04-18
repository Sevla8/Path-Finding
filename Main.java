import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class Main {
	public static void main(String[] args) {

		ControlPanel controlPanel = new ControlPanel("barrier", "path", new Point(0, 0), new Dimension(700, 100), Color.BLUE);
		MainPanel mainPanel = new MainPanel(500, 10, Color.GREEN, controlPanel);

		MyFrame frame = new MyFrame(mainPanel, controlPanel);
		frame.run();
	}
}
