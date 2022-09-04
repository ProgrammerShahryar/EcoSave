package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.time.LocalDate;
import java.util.ArrayList;


public class EcoSave {
	
	/**
	* Initalizing Variables and array list
	*/
	
	private ArrayList<User> user;
	private ArrayList<Material> material;
	private ArrayList<Submission> submission;
	
	public EcoSave() {
        setUser(new ArrayList<>());
        setMaterials(new ArrayList<>());
        setSubmissions(new ArrayList<>());
    }
	/*adding collector and recycler and returning them*/
	public boolean addCollector(String username, String password, 
	    String fullName, double totalpoints, String address) {
	    return getUser().add(new Collector(username, password,  
	    fullName, totalpoints, address));
	}
	
	public boolean addRecycler(String username, String password, 
		String fullName, double totalpoints, String ecolevel) {
		return getUser().add(new Recycler(username, password,  
		fullName, totalpoints, ecolevel));
	}
	/*finding recycler and collector and returning fullname*/
	public String findRecycler() {
	        for (User user: getUser())
	            if (user instanceof Recycler) {
	                Recycler r = (Recycler) user;
	                return r.getFullname();
	            }
	        return null;
	    }
	  
	public String findCollector() {
	        for (User user: getUser())
	            if (user instanceof Collector) {
	                Collector c = (Collector) user;
	                return c.getFullname();
	            }
	        return null;
	    }
	/*finding collector and recycler without returning fullname*/
	public Collector findCollectors(String username) {
		for (User user: getUser())
            if (user instanceof Collector) {
            	if (user.getUsername().equalsIgnoreCase(username)) {
                Collector c = (Collector) user;
                return c;
            }}
        return null;
    }
	
	public Recycler findRecycler(String username) {
		for (User user: getUser())
            if (user instanceof Recycler) {
            	if (user.getUsername().equalsIgnoreCase(username)) {
                Recycler r = (Recycler) user;
                return r;
            }}
        return null;
    }
	/*returning all materials*/
	public String allMaterials() {
		return getMaterials().toString();
	}
	/*view submissions method*/
	public String viewRecyclerSubmission(String username) {
		Recycler r = findRecycler(username);
		return r.getSubmission().toString();
	}
	
	public String viewSubmission(String id) {	
		Material m = findMaterial(id);
		return m.getSubmission().toString();
	}
	/*getting all collectors method*/
	public String allCollectors() {
		return getUser().toString();
	}
	/*adding material for collector method*/
	public void addMaterialToCollector(Collector collector, String materialid) {
		Material m = findMaterial(materialid);
		collector.addMaterial(m);
		m.addCollector(collector);
	}
	/*adding submission of recyler while connecting each other to there classes so can retrieve it*/
	public void addSubmissionOfRecycler(String id, Collector collector, Recycler recycler, LocalDate proposeddate) {
		Submission sub = new Submission(proposeddate, proposeddate, 0, 0, "Proposed");
		Material m = findMaterial(id);
		sub.setMaterial(m);
	    sub.setRecycler(recycler);
	    sub.setCollector(collector);
	    recycler.addSubmission(sub);
	    collector.addSubmission(sub);
	    m.addSubmission(sub);
	}
	/*finding user method*/
	public User findUser(String username) {
        for (User user : getUser()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
	
	/*adding materials and submission methods*/
	public void addMaterial(Material material) {
        getMaterials().add(material);
    }
	
	public void addSubmission(Submission submission) {
        getSubmissions().add(submission);
    }
	/*finding submissions and materials by id*/
	public Material findMaterial(String materialid) {
        for (Material m: getMaterials())
            if (m.getMaterialid().equalsIgnoreCase(materialid))
                return m;
        return null;
    }
	
	public Submission findSubmission(String id) {
		for (Material m: getMaterials()) {
            Submission s = m.findSubmission(id);
            if (s != null)
                return s;
		}
        return null;
    }
	
	public int noOfMaterial() {
        return getMaterials().size();
    }

	/*getters and setters for retrieving data*/
	public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }
    
    public ArrayList<Material> getMaterials() {
        return material;
    }

    public void setMaterials(ArrayList<Material> material) {
        this.material = material;
    }
    
    public ArrayList<Submission> getSubmissions() {
        return submission;
    }

    public void setSubmissions(ArrayList<Submission> submission) {
        this.submission = submission;
    }
    /*adding admin method*/
    public boolean addAdmin(String username, String password, 
        	String fullName, double totalpoints) {
            return getUser().add(new Admin(username, password,  
            	fullName, 1.1));
        }

}
