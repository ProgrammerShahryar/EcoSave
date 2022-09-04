package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.util.ArrayList;

public class Recycler extends User { /*Class extends User so getting data from user since its superclass*/
	
	/**
	* Initalizing Variables and array list
	*/
	
	 private String ecolevel;
	 
	 private ArrayList<Submission> submission;
	 
	 public Recycler(String username, String password, String fullname,
		 double totalpoints, String ecolevel) {
		 super(username, password, fullname, totalpoints);
		 setEcolevel(ecolevel);
		 setSubmission(new ArrayList<>());
	 }
	 /*Getters and Setters*/
	public String getEcolevel() {
		return ecolevel;
	}

	public void setEcolevel(String ecolevel) {
		this.ecolevel = ecolevel;
	}

	public ArrayList<Submission> getSubmission() {
		return submission;
	}

	public void setSubmission(ArrayList<Submission> submission) {
		this.submission = submission;
	}
	/*Method for Retrieving all submissions by Recycler*/
	public String allSubmissions() {
		String sub = "";
		for (Submission col: getSubmission())
			sub += col.getSubmissionid() + "\n";
		return sub;
	}
	/*Method for adding submission by Recycler*/
	public void addSubmission(Submission submission) {
        getSubmission().add(submission);
    }
	
	public String toString() {
		return "Recycler [ecolevel=" + ecolevel + "]"; /*toString method showing all data in array list format*/
	}

}
