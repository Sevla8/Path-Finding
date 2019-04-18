import java.util.PriorityQueue;
import java.util.HashMap;

public class Algorithme {
	public Case[][] tab;
	public PriorityQueue<Case> openList;
	public boolean[][] visited;
	public HashMap<Coord, Coord> mapPath;

	public Algorithme(int n, int m) {
		this.tab = new Case[n][m];
		for (int i = 0; i < n; i += 1) {
			for (int j = 0; j < m; j += 1) {
					this.tab[i][j] = new Case(new Coord(i, j), 999999999, 999999999);
			}
		}
		this.openList = new PriorityQueue<Case>();
		this.visited = new boolean[n][m];
		for (boolean[] row : this.visited) {
			for (boolean cell : row) {
				cell = false;
			}
		}
		this.mapPath = new HashMap<Coord, Coord>();
	}

	public void algo(Coord start, Coord end) {
		//	step 1
		this.tab[start.x][start.y].cout = 0;
		this.tab[start.x][start.y].estimation = this.tab[start.x][start.y].cout + this.tab[start.x][start.y].heuristique(start, end);
		this.openList.add(this.tab[start.x][start.y]);

		//	step 2
		while ()
	}
}
