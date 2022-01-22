package beans;

public class Place {

	private int id;
	private int numeroPla;
	private String etat;
	private Section section;

	public Place(int id, int numeroPla, String etat , Section section) {

		this.id = id;
		this.numeroPla = numeroPla;
		this.etat = etat;
		this.section = section;
	}

	public Place(int numeroPla, String etat , Section section) {

		this.numeroPla = numeroPla;
		this.etat = etat;
		this.section = section;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroPla() {
		return numeroPla;
	}

	public void setNumeroPla(int numeroPla) {
		this.numeroPla = numeroPla;
	}

	

	public String getEtat() {
		return etat;
	}

	

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "numeroPlace=" + numeroPla + ", etat=" + etat + " Section "  +section;
	}

	

}
