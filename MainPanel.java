import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener {
	public int[][] tab;
	public int large;
	public Coord startingCase;
	public ArrayList<Coord> path;
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
		this.path = null;
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
		g.setColor(Color.BLACK);
		for (int i = 0; i < this.tab.length; i += 1) {
			for (int j = 0; j < this.tab[0].length; j += 1) {
				if (this.tab[i][j] == 1) {
					g.fillRect(i*this.large, j*this.large, this.large, this.large);
				}
			}			
		}
		if (this.path != null && !this.path.isEmpty()) {
			g.setColor(Color.RED);
			for (Coord coord : this.path) {
				g.fillOval(coord.x*this.large, coord.y*this.large, this.large, this.large);
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
				int x = e.getX()/this.large;
				int y = e.getY()/this.large;
				if (x < this.tab.length && y < this.tab[0].length && x >= 0 && y >= 0)
					this.path = this.algorithm(this.startingCase, new Coord(x, y));
			}
		}
		System.out.println(this.toString());
		this.repaint();
	}

	public void mouseClicked(MouseEvent e) {
		if (this.controlPanel.button2.isSelected()) {
			int x = e.getX()/this.large;
			int y = e.getY()/this.large;
			if (x < this.tab.length && y < this.tab[0].length && x >= 0 && y >= 0) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					this.startingCase = new Coord(x, y);
					System.out.println(this.toString());
				}
				else if (e.getButton() == MouseEvent.BUTTON3) {
					this.startingCase = null;
					System.out.println(this.toString());
				}
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
		// string += "tab : \n";
		// for (int[] row : this.tab) {
		// 	for (int cell : row) {
		// 		string += cell + " ";
		// 	}
		// 	string += "\n";
		// }

		// string += "large : \n";
		// string += this.large + "\n";

		// string += "startingCase : \n";
		// if (this.startingCase != null)
		// 	string += this.startingCase.toString() + "\n";

		string += "path : \n";
		if (this.path != null) {
			for (Coord coord : this.path) {
				string += coord.toString() + "	";
			}
		}

		return string;
	}

	public ArrayList<Coord> algorithm(Coord start, Coord end) {
		//	init
		int n = this.tab.length;
		int m = this.tab[0].length;

		Case[][] caseTab = new Case[n][m];
		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < m; j += 1) {
					caseTab[i][j] = new Case(new Coord(i, j), 999999999, 999999999);
			}
		}

		PriorityQueue<Case> openList = new PriorityQueue<Case>(new CaseComparator());
		
		boolean[][] visited = new boolean[n][m];
		for (boolean[] row : visited) {
			for (boolean cell : row) {
				cell = false;
			}
		}

		HashMap<Coord, Coord> mapPath = new HashMap<Coord, Coord>();

		//	step 1
		caseTab[start.x][start.y].cost = 0;
		caseTab[start.x][start.y].refineEstimation(end);

		openList.add(caseTab[start.x][start.y]);

		//	step 2
		while (!openList.isEmpty()) {
			//	(a)	
			Case c = openList.poll();
			//	(b)
			if (c != null && c.coord.equals(end)) {
				System.out.println("111111111111111111111111111");
				ArrayList<Coord> result = new ArrayList<Coord>();
				Coord tmp = mapPath.get(end);
				while (tmp != null) {
					System.out.println("000000000000000000000000");
					result.add(tmp);
					tmp = mapPath.get(tmp);
				}
				return result;
			}
			//	(c)
			else 
				visited[c.coord.x][c.coord.y] = true;
			//	(d)
			for (Case[] row : caseTab) {
				for (Case a : row) {
					if (a.coord.isNeighbour(c.coord) && this.tab[a.coord.x][a.coord.y] != 1 && !visited[a.coord.x][a.coord.y]) {
						if (!openList.contains(a)) {
							a.cost = c.cost + 1;
							a.refineEstimation(end);
							openList.add(a);
							mapPath.put(a.coord, c.coord);
							System.out.println("test");
						}
						else {
							if (c.cost + 1 < a.cost) {
								a.cost = c.cost + 1;
								a.refineEstimation(end);
								mapPath.put(a.coord, c.coord);
							}
							System.out.println("testtesttesttest");
						}
					}
				}
			}

		}

		// step 3
		return null;
	}
}
