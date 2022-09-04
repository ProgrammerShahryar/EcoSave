package ecoSave;

/**
*
* @author Shahryar Panjwani
* #B1400290
*/

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class EcoSaveConsole {
	
	/**
	* Initalizing Variables, Date and time format, scanner for input, and getting which user logged in.
	*/
	
	private static final int MAX_LOGIN_TRIES = 10;
	private static final int MAX_PASSWORD_TRIES = 3;

    static Scanner kbd;
    static DateTimeFormatter dateFormat;
    static EcoSave ecoSave;
    static User loginUser;

	public static void main(String[] args) {
		dateFormat = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        kbd = new Scanner(System.in);
        ecoSave = new EcoSave();
        
        System.out.println("Welcome to EcoSave!!!\n");
        
        initUsers();
        /*Menu code for signup and login using char and case*/
        char choice = doMenu();
        while (choice != '0') {
            switch (choice) {
                case '1':
                    signUp("Recycler");
                    break;
                case '2':
                    signUp("Collector");
                    break;
                case '3':
                	login();
                    break;
                default:
                    printErrorMessage();
                    break;
            }
            System.out.println();
            choice = doMenu();
        }
        System.out.println("Thank you for using EcoSave!");
    }
	/*adding admin default*/
	private static void initUsers() {
		ecoSave.addAdmin("shahryar", "12345678", "shahryar", 1.1);		
	}
	/*displaying menu for signup and login*/
	public static char doMenu() {
        System.out.println("EcoSave");
        System.out.println("1. Sign-up (Recycler)");
        System.out.println("2. Sign-up (Collector)");
        System.out.println("3. Login");
        System.out.println();
        System.out.println("0. Quit");
        System.out.println();
        System.out.print("Your choice? ");
        return kbd.nextLine().trim().charAt(0);
    }
	/*Registering user method*/
	public static void signUp(String userType) {
        System.out.println("Create " + userType + " ...");

        String username = getUsername();
        String password = getPassword();
        String fullName = getFullName();
        
        if (userType.equalsIgnoreCase("Recycler")) {
            // ADDITIONAL FOR APPLICANT...
            double totalpoints = 0;
            String ecolevel = "Newbie";
            ecoSave.addRecycler(username, password, fullName, totalpoints, 
                ecolevel);
        }
        else if (userType.equalsIgnoreCase("Collector")) {
        	 double totalpoints = 0;
             String address = getAddress();
             ecoSave.addCollector(username, password, fullName, totalpoints, 
                 address);
        }
        else {
        	
        }
            
        System.out.println("New user created successfully!");
    }
	/*login method*/
	public static void login() {
        loginUser = signIn();
        if (loginUser != null)
	        if (loginUser instanceof Recycler)
	            recyclerTasks();
	        else if (loginUser instanceof Collector)
	            collectorTasks();
	        else 
	        	adminTasks();
    }
	/*code for recycler task menu*/
	 public static void recyclerTasks() {       
	        char ch = recyclerTasksMenu();
	        while (ch != '0') {
	            switch (ch) {
	            	case '1':
	                    recycleItems();
	                    break;
	                case '2':
	                    viewSubmission();
	                    break;
	                default:
	                    printErrorMessage();
	                    break;
	            }
	            ch = recyclerTasksMenu();
	        }
	 }
	 /*code for collector task menu*/
	 public static void collectorTasks() {       
	        char ch = collectorTasksMenu();
	        while (ch != '0') {
	            switch (ch) {
	            	case '1':
	            		collectMaterial();
	            		break;
	                case '2':
	                    recordMaterial();
	                    break;
	                case '3':
	                    viewSubmission();
	                    break;
	                default:
	                    printErrorMessage();
	                    break;
	            }
	            ch = collectorTasksMenu();
	        }
	 }
	 /*code for admin task menu*/
	 public static void adminTasks() {       
	        char ch = adminTasksMenu();
	        while (ch != '0') {
	            switch (ch) {
	                case '1':
	                    addMaterial();
	                    break;
	                case '2':
	                    changeMaterial();
	                    break;
	                case '3':
	                    deleteMaterial();
	                    break;
	                case '4':
	                    viewSubmission();
	                    break;
	                default:
	                    printErrorMessage();
	                    break;
	            }
	            ch = adminTasksMenu();
	        }
	 }
	 /*displaying admin, recycler, and collector tasks menu*/
	 public static char adminTasksMenu() {
	        System.out.println();
	        System.out.println("Choose");
	        System.out.println("1. Add Material");
	        System.out.println("2. Change Material");
	        System.out.println("3. Delete Material();");
	        System.out.println("4. View Submission History();");
	        System.out.println();
	        System.out.println("0. LOGOUT [Back to main menu]");
	        System.out.println();
	        System.out.print("Your choice: ");
	        return kbd.nextLine().charAt(0);
	    }
	 
	 public static char recyclerTasksMenu() {
	        System.out.println();
	        System.out.print("Welcome " + ecoSave.findRecycler());
	        System.out.println();
	        System.out.println("Choose");
	        System.out.println("1. Make appointment for submission");
	        System.out.println("2. View Submission History");
	        System.out.println();
	        System.out.println("0. LOGOUT [Back to main menu]");
	        System.out.println();
	        System.out.print("Your choice: ");
	        return kbd.nextLine().charAt(0);
	    }
	 
	 public static char collectorTasksMenu() {
	        System.out.println();
	        System.out.print("Welcome " + ecoSave.findCollector());
	        System.out.println();
	        System.out.println("Choose");
	        System.out.println("1. Propose Materials");
	        System.out.println("2. Record Material Submission");
	        System.out.println("3. View Submission History");
	        System.out.println();
	        System.out.println("0. LOGOUT [Back to main menu]");
	        System.out.println();
	        System.out.print("Your choice: ");
	        return kbd.nextLine().charAt(0);
	    }
	 /*methods called when user selects on menu*/
	 /*Collector propose material method*/
	 public static void collectMaterial() {
		 System.out.println(ecoSave.getMaterials());
		 System.out.print("Enter material id: ");
	     String id = kbd.nextLine();
	     ecoSave.addMaterialToCollector((Collector)loginUser, id);
	     System.out.println("Material added for collector");
	     
	    }
	 /*view submission method*/
	 public static void viewSubmission() {
		 System.out.println(ecoSave.getMaterials());
		 System.out.print("Enter material id: ");
	     String id = kbd.nextLine();
	     System.out.print(ecoSave.viewSubmission(id));
	    }
	 /*record material method*/
	 public static void recordMaterial() {
		 System.out.print("Enter Recycler Username: ");
	     String username = kbd.nextLine();
	     System.out.println(ecoSave.viewRecyclerSubmission(username));
	     System.out.print("Enter Submission ID: ");
	     String id = kbd.nextLine();
	     Submission sub = ecoSave.findSubmission(id);
	     System.out.print("Enter Weight In Kg: ");
	     double kg = kbd.nextDouble();
	     sub.setWeightinkg(kg);
	     sub.setActualdate(LocalDate.now());
	     sub.setStatus("Submitted");
	     sub.setPointsawarded(50);
	     System.out.print("Materials Sumbitted!!! ");
	     kbd.nextLine();
	    }
	 /*add material method*/
	 public static void addMaterial() {
		 System.out.println(ecoSave.getMaterials());
		 System.out.println("Adding New Material");
	     System.out.print("Name: ");
	     String name = kbd.nextLine();
	     System.out.print("Description: ");
	     String description = kbd.nextLine();
	     System.out.print("PointsPerKg: ");
	     double pointsperkg = kbd.nextDouble();       
	     kbd.nextLine();
	     Material mat = new Material(name, description, pointsperkg);

	     ecoSave.addMaterial(mat);
	     System.out.println("Material Added!");
	 }
	 /*make appointment for submission method*/
	 public static void recycleItems() {
		 System.out.println(ecoSave.getMaterials());
		 System.out.print("Enter material id: ");
	     String id = kbd.nextLine();
	     Material m = ecoSave.findMaterial(id);
		 System.out.println("Collectors " + m.allCollectors());
	     System.out.print("Enter Collector Username: ");
	     String user = kbd.nextLine();
	     Collector collector = ecoSave.findCollectors(user);
	     System.out.print("Enter Proposed Date (dd/mm/yyyy): ");
	     String date = kbd.nextLine();
	     LocalDate proposeddate = LocalDate.parse(date, dateFormat);
	     ecoSave.addSubmissionOfRecycler(id, collector, (Recycler)loginUser, proposeddate);
	     System.out.print("Submission has been processed");
	 }
	 /*updating material method for admin*/
	 public static void changeMaterial() {
		 if (ecoSave.noOfMaterial() == 0) {
	            System.out.println("No Materials");
	        } else {
	            System.out.println("All Materials in the system:");
	            System.out.println(ecoSave.getMaterials());
	            System.out.println("change Material information");
		        System.out.print("Enter material id: ");
		        String id = kbd.nextLine();
		        Material m = ecoSave.findMaterial(id);
		        System.out.println("Enter material name:");
		        String name = kbd.nextLine();
		        m.setMaterialname(name);
		        System.out.println("Enter new description:");
		        String description = kbd.nextLine();
		        m.setDescription(description);
		        System.out.println("Enter new pointsperkg:");
		        double points = kbd.nextDouble();
		        m.setPointsperkg(points);
		        System.out.println("Material Updated!");		   
		        kbd.nextLine();
	        }
		 
	 }
	 /*delete material method(admin)*/
	 public static void deleteMaterial() {
		 System.out.println(ecoSave.getMaterials());
		 System.out.print("Enter material id: ");
	     String id = kbd.nextLine();
	     Material m = ecoSave.findMaterial(id);
	     m.setMaterialname(null);
	     m.setDescription(null);
	     m.setPointsperkg(0);	 
	     System.out.println("Material Added!");
	 }
	 /*finding user signin method*/
	 /*checking validation and telling user to try again*/
	 public static User signIn() {
		 System.out.println("\nSign in");
	     System.out.print("Username: ");
	     String inUsername = kbd.nextLine();
	     User loginUser = ecoSave.findUser(inUsername);
	     int maxTries = 1;
	     while (loginUser == null) {
	         System.out.println("Username not found!\n");
	            
	         if (maxTries++ == MAX_LOGIN_TRIES) {
	        	return null;
	        }
	        	
	         System.out.print("Username: ");
	         inUsername = kbd.nextLine();
	         loginUser = ecoSave.findUser(inUsername);    
	        }
	        System.out.print("Password: ");
	        String inPassword = kbd.nextLine();
	        
	        maxTries = 1;
	        while (!loginUser.getPassword().equals(inPassword)) {
	            System.out.println("Invalid password!");
	            if (maxTries++ == MAX_PASSWORD_TRIES) {
	            	System.out.println("Please try again later!");
	            	return null;
	            }
	            System.out.println();
	            System.out.print("Password: ");
	            inPassword = kbd.nextLine();
	        }
	        System.out.println("Sign in successfully!");
	        return loginUser;
	}
	 /*getting username method with validation*/
    public static String getUsername() {
        System.out.print("Username: ");
        String username = kbd.nextLine();
        while (ecoSave.findUser(username) != null || username.equals("")) {
            if (username.equals("")) {
                System.out.println("Username cannot be blank! Please "
                        + "enter username!\n");
            } else {
                System.out.println("Username already exists. "
                        + "Please enter another username!\n");
            }
            System.out.print("Username: ");
            username = kbd.nextLine();
        }
        return username;
    }

    /**
     * Get valid password
     *
     * @return String password
     */
    public static String getPassword() {
        System.out.print("Password (Min. length: 8): ");
        String password = kbd.nextLine();
        while (password.length() < 8) {
            if (password.equals("")) {
                System.out.println("Password cannot be blank! "
                        + "Please enter password!\n");
            } else {
                System.out.println("Password must contain at least "
                        + "8 characters!\n");
            }

            System.out.print("Password (Min. length: 8): ");
            password = kbd.nextLine();
        }
        return password;
    }

    /**
     * Get valid full name
     *
     * @return String full name
     */
    public static String getFullName() {
        System.out.print("Full name: ");
        String fullName = kbd.nextLine().trim();
        while (fullName.equals("")) {
            System.out.println("Full name cannot be blank! "
                    + "Please enter full name!\n");
            System.out.print("Full name: ");
            fullName = kbd.nextLine();
        }
        return fullName;
    }
    
    /*getting address method with validation*/
    public static String getAddress() {
    	System.out.print("Address: ");
        String address = kbd.nextLine().trim();
        while (address.equals("")) {
            System.out.println("Address cannot be blank! "
                    + "Please enter Address!\n");
            System.out.print("Address: ");
            address = kbd.nextLine();
        }
        return address;
    }    
    
    /**
     * Display error message
     */
    public static void printErrorMessage() {
        System.out.println("Invalid choice! Try again!");
    }
	
	
	
}
