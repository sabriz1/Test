package beans;

public class Ticket {
	private int id;
	private String heureDentrer;
	private Place place;



	public Ticket(String heureDentrer, Place place) {
		super();
		this.heureDentrer = heureDentrer;
		this.place = place;
	}

	public Ticket(int id, String heureDentrer, Place place) {
		super();
		this.id = id;
		this.heureDentrer = heureDentrer;
		this.place = place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeureDentrer() {
		return heureDentrer;
	}

	public void setHeureDentrer(String heureDentrer) {
		this.heureDentrer = heureDentrer;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", heureDentrer=" + heureDentrer + ", Place=" + place + "]";
	}
	
}
