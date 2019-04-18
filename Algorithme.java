import java.util.PriorityQueue;
import java.util.HashMap;
import java.awt.Point;

public class Algorithme {
	public Case[][] tab;
	public PriorityQueue<Case> openList;
	public boolean[][] visited;
	public HashMap<Point, Point> mapPath;

	public Algorithme(int n, int m) {
		this.tab = new Case[n][m];
		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < m; j += 1) {
					this.tab[i][j] = new Case(new Point(i, j), 999999999, 999999999);
			}
		}
		this.openList = new PriorityQueue<Case>();
		this.visited = new boolean[n][m];
		for (boolean[] row : this.visited) {
			for (boolean cell : row) {
				cell = false;
			}
		}
		this.mapPath = new HashMap<Point, Point>();
	}

	public void algo(Point start, Point end) {
		//	step 1
		int x = (int)start.getX();
		int y = (int)start.getY();
		this.tab[x][y].cost = 0;
		this.tab[x][y].estimation = this.tab[x][y].cost + this.tab[x][y].heuristique(start, end);
		this.openList.add(this.tab[x][y]);

		//	step 2
		// while ()
	}
}
