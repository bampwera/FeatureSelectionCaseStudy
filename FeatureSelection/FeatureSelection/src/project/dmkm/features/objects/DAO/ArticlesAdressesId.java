package project.dmkm.features.objects.DAO;

// Generated Jun 2, 2013 1:29:28 AM by Hibernate Tools 3.4.0.CR1

/**
 * ArticlesAdressesId generated by hbm2java
 */
public class ArticlesAdressesId implements java.io.Serializable {

	private int id;
	private int d1;
	private int d2;
	private String adresse;

	public ArticlesAdressesId() {
	}

	public ArticlesAdressesId(int id, int d1, int d2) {
		this.id = id;
		this.d1 = d1;
		this.d2 = d2;
	}

	public ArticlesAdressesId(int id, int d1, int d2, String adresse) {
		this.id = id;
		this.d1 = d1;
		this.d2 = d2;
		this.adresse = adresse;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getD1() {
		return this.d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public int getD2() {
		return this.d2;
	}

	public void setD2(int d2) {
		this.d2 = d2;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ArticlesAdressesId))
			return false;
		ArticlesAdressesId castOther = (ArticlesAdressesId) other;

		return (this.getId() == castOther.getId())
				&& (this.getD1() == castOther.getD1())
				&& (this.getD2() == castOther.getD2())
				&& ((this.getAdresse() == castOther.getAdresse()) || (this
						.getAdresse() != null && castOther.getAdresse() != null && this
						.getAdresse().equals(castOther.getAdresse())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getD1();
		result = 37 * result + this.getD2();
		result = 37 * result
				+ (getAdresse() == null ? 0 : this.getAdresse().hashCode());
		return result;
	}

}
