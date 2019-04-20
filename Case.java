import java.lang.Math;

public class Case {
	public Coord coord;
	public int cost;
	public int estimation;

	public Case(Coord coord, int cost, int estimation) {
		this.cost = cost;
		this.estimation = estimation;
		this.coord = coord;
	}

	public int heuristique(Coord c, Coord g) {
		return Math.abs(c.x - g.x) + Math.abs(c.y - g.y);
	}

	public void refineEstimation(Coord end) {
		this.estimation = this.cost + this.heuristique(this.coord, end);
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Case c = (Case) object;
		if (!this.coord.equals(c.coord))
			return false;
		return true;
	}

	public String toString() {
		String string = new String("");
		string += this.coord.toString();
		string += "cost : \n";
		string += this.cost + "\n";
		string += "estimation : \n";
		string += this.estimation + "\n";
		return string;
	}
}
