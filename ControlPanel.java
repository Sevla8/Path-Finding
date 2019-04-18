import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public class ControlPanel extends JPanel {
	public JRadioButton button1;
	public JRadioButton button2;

	public ControlPanel(String alpha, String beta, Point location, Dimension size, Color background) {
		ButtonGroup group = new ButtonGroup();

		this.button1 = new JRadioButton(alpha);
		this.button2 = new JRadioButton(beta);

		group.add(this.button1);
		group.add(this.button2);

		this.add(this.button1);
		this.add(this.button2);
		
		this.setBackground(background);
		this.setSize((int)size.getWidth(), (int)size.getHeight());
		this.setLocation((int)location.getX(), (int)location.getY());
	}
}
