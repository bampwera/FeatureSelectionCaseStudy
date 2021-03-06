package project.dmkm.features.objects.DAO;

// Generated Jun 2, 2013 1:29:28 AM by Hibernate Tools 3.4.0.CR1

/**
 * Articles generated by hbm2java
 */
public class Articles implements java.io.Serializable {

	private int id;
	private String authors;
	private String title;
	private String journal;
	private String type;
	private Integer numrefs;
	private Integer timesCited;
	private String doi;
	private Integer year;
	private String volume;
	private String issue;
	private String bp;
	private String ep;
	private String abbr;
	private String ut;
	private Integer nsr;

	public Articles() {
	}

	public Articles(int id) {
		this.id = id;
	}

	public Articles(int id, String authors, String title, String journal,
			String type, Integer numrefs, Integer timesCited, String doi,
			Integer year, String volume, String issue, String bp, String ep,
			String abbr, String ut, Integer nsr) {
		this.id = id;
		this.authors = authors;
		this.title = title;
		this.journal = journal;
		this.type = type;
		this.numrefs = numrefs;
		this.timesCited = timesCited;
		this.doi = doi;
		this.year = year;
		this.volume = volume;
		this.issue = issue;
		this.bp = bp;
		this.ep = ep;
		this.abbr = abbr;
		this.ut = ut;
		this.nsr = nsr;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthors() {
		return this.authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJournal() {
		return this.journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getNumrefs() {
		return this.numrefs;
	}

	public void setNumrefs(Integer numrefs) {
		this.numrefs = numrefs;
	}

	public Integer getTimesCited() {
		return this.timesCited;
	}

	public void setTimesCited(Integer timesCited) {
		this.timesCited = timesCited;
	}

	public String getDoi() {
		return this.doi;
	}

	public void setDoi(String doi) {
		this.doi = doi;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getBp() {
		return this.bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getEp() {
		return this.ep;
	}

	public void setEp(String ep) {
		this.ep = ep;
	}

	public String getAbbr() {
		return this.abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getUt() {
		return this.ut;
	}

	public void setUt(String ut) {
		this.ut = ut;
	}

	public Integer getNsr() {
		return this.nsr;
	}

	public void setNsr(Integer nsr) {
		this.nsr = nsr;
	}

}
