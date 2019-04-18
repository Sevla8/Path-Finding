import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.Point;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
	public int[][] tab;
	public int large;
	public Point startingCase;
	public ArrayList<Point> path;
	public ControlPanel controlPanel;
	public int click;

	public MainPanel(int height, int large, Color background, ControlPanel controlPanel) {
		int n = (int)controlPanel.getSize().getWidth()/large;
		int m = height/large;

		this.tab = new int[n][m];
		for (int[] row : this.tab) {
			for (int cell : row) {
					cell = 0;
			}
		}
		this.large = large;
		this.startingCase = null;
		this.path = new ArrayList<Point>();
		this.controlPanel = controlPanel;
		this.click = 0;

		this.setBackground(background);
		this.setSize(n*large, m*large);
		this.setLocation((int)controlPanel.getLocation().getX(), (int)controlPanel.getLocation().getY()+(int)controlPanel.getSize().getHeight());

		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < this.tab.length; i += 1) {
			for (int j = 0; j < this.tab[0].length; j += 1) {
				if (this.tab[i][j] == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(i*this.large, j*this.large, this.large, this.large);
				}
			}			
		}
		if (!this.path.isEmpty()) {
			for (Point point : this.path) {
				g.fillOval(point.x*this.large, point.y*this.large, this.large, this.large);
			}
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (this.controlPanel.button1.isSelected()) {
			int x = e.getX()/this.large;
			int y = e.getY()/this.large;
			if (x < this.tab.length && y < this.tab[0].length && x >= 0 && y >= 0) {
				if (this.click == 1) {
					this.tab[x][y] = 1;
				}
				else if (this.click == 3) {
					this.tab[x][y] = 0;
				}
			}
		}
		this.repaint();
	}
	
	public void mouseMoved(MouseEvent e) {
		if (this.controlPanel.button2.isSelected()) {
			if (this.startingCase != null) {

			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (this.controlPanel.button2.isSelected()) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				this.startingCase = new Point(e.getX()/this.large, e.getY()/this.large);
			}
			else if (e.getButton() == MouseEvent.BUTTON3) {
				this.startingCase = null;
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			this.click = 1;
		else if (e.getButton() == MouseEvent.BUTTON3)
			this.click = 3;
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public String toString() {
		String string = new String("");
		string += "tab : \n";
		for (int[] row : this.tab) {
			for (int cell : row) {
				string += cell + " ";
			}
			string += "\n";
		}

		string += "large : \n";
		string += this.large + "\n";

		return string;
	}
}
