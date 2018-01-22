/**
 * Created by 436608 on 22-1-2018.
 */
public class Support_Employee extends Employee {
    private String expertise; //setting the properties of the employee

    /**
     * constuctor for the usersers
     *
     * @param username   username of the user
     * @param password   password of the user
     * @param expertise  expertise of the user
     */
    public Support_Employee(String username, String password, String expertise) {
        super(username, password, "Helpdesk");
        this.expertise = expertise;
    }

    @Override
    public String toString() {
        return  username + " (" + department + ", Expertise: " + expertise + ")";
    }
}
