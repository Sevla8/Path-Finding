import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
	public int[][] tab;
	public int large = 10;
	public Coord caseDepart;
	public ArrayList<Coord> path;
	public ControlPanel controlPanel;
	public int click;

	public MainPanel(int n, int m, ControlPanel controlPanel) {
		this.tab = new int[n][m];
		for (int[] row : this.tab) {
			for (int cell : row) {
					cell = 0;
			}
		}
		this.setBackground(Color.GREEN);
		this.setSize(500, 500);
		this.setLocation(0, 200);
		this.caseDepart = null;
		this.path = new ArrayList<Coord>();
		this.controlPanel = controlPanel;
		this.click = 0;

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.tab[30][50] = 1;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < this.tab.length; i += 1) {
			for (int j = 0; j < this.tab[i].length; j += 1) {
				if (this.tab[i][j] == 1) {
					g.setColor(Color.BLACK);
					g.fillRect(i*large, j*large, large, large);
				}
			}			
		}
		if (!this.path.isEmpty()) {
			for (Coord coord : this.path) {
				g.fillOval(coord.x*this.large, (coord.y)*this.large, this.large, this.large);
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (this.controlPanel.button2.isSelected()) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				this.caseDepart.x = e.getX()/this.large;
			}
			else if (e.getButton() == MouseEvent.BUTTON3) {
				this.caseDepart = null;
				this.click = 3;
			}
		}
		this.repaint();
	}
	
	public void mouseMoved(MouseEvent e) {
		if (this.controlPanel.button2.isSelected()) {
			
		}
	}

	public void mouseDragged(MouseEvent e) {
		if (this.controlPanel.button1.isSelected()) {
			int x = e.getX()/this.large;
			int y = e.getY()/this.large;
			if (x < this.tab.length && y < this.tab[0].length) {
				if (this.click == 1) {
					
						this.tab[e.getX()/this.large][e.getY()/this.large] = 1;
				}
				else if (this.click == 3) {
					this.tab[e.getX()/this.large][e.getY()/this.large] = 0;
				}
			}
		}
		this.repaint();
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
}
