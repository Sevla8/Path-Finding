public class Coord {
	public int x;
	public int y;

	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		return this.x * 1000 + this.y;
	}

	public boolean equals(Object object) {
		if (object == null)
			return false;
		if (this.getClass() != object.getClass())
			return false;
		Coord coord = (Coord) object;
		if (this.x != coord.x)
			return false;
		if (this.y != coord.y)
			return false;
		return true;
	}

	public boolean isNeighbour(Coord coord) {
		if (this.x + 1 == coord.x && this.y == coord.y)
			return true;
		if (this.x - 1 == coord.x && this.y == coord.y)
			return true;
		if (this.x == coord.x && this.y + 1 == coord.y)
			return true;
		if (this.x == coord.x && this.y - 1 == coord.y)
			return true;
		return false;
	}

	public String toString() {
		String string = new String("");
		string += "x : \n";
		string += this.x + "\n";
		string += "y : \n";
		string += this.y + "\n";
		return string;
	}
}