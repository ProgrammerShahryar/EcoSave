package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.util.ArrayList;

public class Collector extends User { /*Class extends User so getting data from user since its superclass*/
	
	/**
	* Initalizing Variables and array list
	*/
	
	 private String address;
	 
	 private ArrayList<Material> material;
	 private ArrayList<Submission> submission;
	 
	 public Collector(String username, String password, String fullname,
		 double totalpoints, String address) {
		 super(username, password, fullname, totalpoints);
		 setAddress(address);
		 setMaterial(new ArrayList<>());
		 setSubmission(new ArrayList<>());
	 }
	 /*Getters and Setters*/
	public String getAddress() {
		return address;
	}
	/*Method for allowing collecter to propose materials*/
	public void addMaterial(Material material) {
        getMaterial().add(material);
    }
	/*Method for finding materials that collector wants to collect*/
	public Material findMaterial(String materialid) {
        for (Material m: getMaterial())
            if (m.getMaterialid().equalsIgnoreCase(materialid))
                return m;
        return null;
    }
	/*Method for Retrieving all materials by collector*/
	public String allMaterials() {
		String m = "";
		for (Material col: getMaterial())
			m += col.getMaterialid() + "\n";
		return m;
	}
	/*Method for Retrieving all submissions by collector*/
	public String allSubmissions() {
		String sub = "";
		for (Submission col: getSubmission())
			sub += col.getSubmissionid() + "\n";
		return sub;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Material> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<Material> material) {
		this.material = material;
	}
	/*Method for adding submission by collector*/
	public void addSubmission(Submission submission) {
        getSubmission().add(submission);
    }

	public ArrayList<Submission> getSubmission() {
		return submission;
	}

	public void setSubmission(ArrayList<Submission> submission) {
		this.submission = submission;
	}

	public String toString() {
		return "Collector [address=" + address + "]"; /*toString method showing all data in array list format*/
	}
	 
}
