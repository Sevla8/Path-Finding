import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class ControlPanel extends JPanel {
	public ButtonGroup group;
	public JRadioButton button1;
	public JRadioButton button2;

	public ControlPanel(String alpha, String beta) {
		this.group = new ButtonGroup();

		this.button1 = new JRadioButton(alpha);
		group.add(this.button1);
		this.add(this.button1);

		this.button2 = new JRadioButton(beta);
		group.add(this.button2);
		this.add(this.button2);

		this.setBackground(Color.BLUE);
		this.setSize(500, 200);
		this.setLocation(0, 0);
	}
}
