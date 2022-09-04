package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.util.ArrayList;

public class Material {
	
	/**
	* Initalizing Variables and array list
	*/
	
	static int genNum = 1; /*auto generating id*/
	private String materialid;
    private String materialname;
    private String description;
    private double pointsperkg;
    
    private ArrayList<Collector> collector;
    private ArrayList<Submission> submission;

	public Material(String materialname, String description, double pointsperkg) {
		setMaterialid();
        setMaterialname(materialname);
        setDescription(description);
        setPointsperkg(pointsperkg);
        setCollector(new ArrayList<>());
        setSubmission(new ArrayList<>());
    }
    
	public Material() {
        this("not set", "not set", 0);
    }
	/*Getters and Setters*/
    public String getMaterialid() {
  		return materialid;
  	}

  	public void setMaterialid() {
  		this.materialid = String.format("M%03d", genNum++);
  	}

  	public String getMaterialname() {
  		return materialname;
  	}

  	public void setMaterialname(String materialname) {
  		this.materialname = materialname;
  	}

  	public String getDescription() {
  		return description;
  	}

  	public void setDescription(String description) {
  		this.description = description;
  	}

  	public double getPointsperkg() {
  		return pointsperkg;
  	}

  	public void setPointsperkg(double pointsperkg) {
  		this.pointsperkg = pointsperkg;
  	}

	public ArrayList<Collector> getCollector() {
		return collector;
	}

	public void setCollector(ArrayList<Collector> collector) {
		this.collector = collector;
	}
	/*Method for linking collector to materials he wants to collect*/
	public void addCollector(Collector collector) {
        getCollector().add(collector);
    }
	/*Method for Retrieving all materials that have been proposed by collector*/
	public String allCollectors() {
		String c = "";
		for (Collector col: getCollector())
			c += col.getUsername() + "\n";
		return c;
	}

	public ArrayList<Submission> getSubmission() {
		return submission;
	}

	public void setSubmission(ArrayList<Submission> submission) {
		this.submission = submission;
	}
	/*Method for adding submissions by collector*/
	public void addSubmission(Submission submission) {
        getSubmission().add(submission);
    }
	/*Method for finding all submissions linked with material*/
	public Submission findSubmission(String id) {
        for (Submission s: getSubmission())
            if (s.getSubmissionid().equalsIgnoreCase(id))
                return s;
        return null;
    }

	public String toString() {
		return "Material [materialid=" + materialid + ", materialname=" + materialname + ", description=" + description
				+ ", pointsperkg=" + pointsperkg + "]"; /*toString method showing all data in array list format*/
	}
  	
}
