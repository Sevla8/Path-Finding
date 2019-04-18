public class Case {
	public Coord coord;
	public int cout;
	public int estimation;

	public Case(Coord coord, int cout, int estimation) {
		this.cout = cout;
		this.estimation = estimation;
		this.coord.x = coord.x;
		this.coord.y = coord.y;
	}

	public int heuristique(Coord c, Coord g) {
		return c.x - g.x + (c.y - g.y);
	}
}