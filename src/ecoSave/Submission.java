package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.time.LocalDate;

public class Submission {
	
	/**
	* Initalizing Variables and array list
	*/
	
	static int subGenID = 1; /*auto generating id*/
	
	private String submissionid;
    private LocalDate proposeddate;
    private LocalDate actualdate;
    private double weightinkg;
    private int pointsawarded;
    private String status;
    private Collector collector;
    private Recycler recycler;
    private Material material;
    
    public Submission(LocalDate proposeddate, LocalDate acutaldate, double weightinkg, int pointsawarded, String status) {
        setSubmissionid();
        setProposeddate(proposeddate);
        setActualdate(actualdate);
        setWeightinkg(weightinkg);
        setPointsawarded(pointsawarded);
        setStatus("Proposed");
    }
    /*Getters and Setters*/
	public String getSubmissionid() {
		return submissionid;
	}

	public void setSubmissionid() {
		this.submissionid = String.format("S%03d", subGenID++);
	}

	public LocalDate getProposeddate() {
		return proposeddate;
	}

	public void setProposeddate(LocalDate proposeddate) {
		this.proposeddate = proposeddate;
	}

	public LocalDate getActualdate() {
		return actualdate;
	}

	public void setActualdate(LocalDate actualdate) {
		this.actualdate = actualdate;
	}

	public double getWeightinkg() {
		return weightinkg;
	}

	public void setWeightinkg(double weightinkg) {
		this.weightinkg = weightinkg;
	}

	public int getPointsawarded() {
		return pointsawarded;
	}

	public void setPointsawarded(int pointsawarded) {
		this.pointsawarded = pointsawarded;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	public Recycler getRecycler() {
		return recycler;
	}

	public void setRecycler(Recycler recycler) {
		this.recycler = recycler;
	}
	
	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
	
	
	public String toString() { /*toString method showing all data in array list format*/
		return "Submission [submissionid=" + submissionid + ", proposeddate=" + proposeddate + ", actualdate="
				+ actualdate + ", weightinkg=" + weightinkg + ", pointsawarded=" + pointsawarded + ", status=" + status
				+ ", collector=" + collector.getUsername() + ", recycler=" + recycler.getUsername() + ", material=" + material + "]";
	}
	
}
