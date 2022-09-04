package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.util.ArrayList;

public class Admin extends User { /*Class extends User so getting data from user since its superclass*/
	/**
	* Initalizing Variables and array list
	*/

	private ArrayList<Material> material;
	private ArrayList<Submission> submission;
	
	public Admin(String username, String password, String fullname,
		double totalpoints) {
		super(username, password, fullname, totalpoints);
		setMaterial(new ArrayList<>());
		setSubmission(new ArrayList<>());
	}
	/*Getters and Setters*/
	public ArrayList<Material> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<Material> material) {
		this.material = material;
	}

	public ArrayList<Submission> getSubmission() {
		return submission;
	}

	public void setSubmission(ArrayList<Submission> submission) {
		this.submission = submission;
	}
	/*Method for letting admin add materials*/
	public void Material(Material material) {
	    getMaterial().add(material);
	}
	
}
