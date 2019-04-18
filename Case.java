import java.awt.Point;

public class Case {
	public Point point;
	public int cost;
	public int estimation;

	public Case(Point point, int cost, int estimation) {
		this.cost = cost;
		this.estimation = estimation;
		this.point = point;
	}

	public int heuristique(Point c, Point g) {
		return (int)c.getX() - (int)g.getX() + ((int)c.getY() - (int)g.getY());
	}
}
