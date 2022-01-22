package beans;

public class Section {

	private int id;
	private String code;
	private Place place;
	private int PrixParHeure;
	private String type;

	public Section(int id, String code, String type , int prixParHeure) {
		super();
		this.id = id;
		this.code = code;
        this.type=type;
		this.PrixParHeure = prixParHeure;
	}

	public Section(String code, String type , int prixParHeure) {
		super();
		this.code = code;
		 this.type=type;
		this.PrixParHeure = prixParHeure;
	}

public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return " SectionName =" + code + ", PrixParHeure=" + PrixParHeure
				+ ", typePlace=" + type  ;
	}

	public int getPrixParHeure() {
		return PrixParHeure;
	}

	public void setPrixParHeure(int prixParHeure) {
		this.PrixParHeure = prixParHeure;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	
}
