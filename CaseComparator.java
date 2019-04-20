import java.util.Comparator;

public class CaseComparator implements Comparator<Case> {

	public int compare(Case c1, Case c2) {
		if (c1.estimation < c2.estimation)
			return -1;
		else if (c1.estimation > c2.estimation)
			return 1;
		else 
			return 0;
	}
}
