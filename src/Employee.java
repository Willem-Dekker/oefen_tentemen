import org.json.JSONObject;

/**
 * Created by 436608 on 22-1-2018.
 */
public class Employee {
    protected String username, password,department; //setting the vars for the class

    public Employee() {
    }

    /**
     * constuctor for the usersers
     * @param username username of the user
     * @param password password of the user
     * @param department department of the user
     */
    public Employee(String username, String password, String department) {
        this.username = username;
        this.password = password;
        this.department = department;
    }

    /**
     * converts a jsonobject of a user to a user object
     * @param jsonObject the jsonobject to convert
     */
    public Employee(JSONObject jsonObject) {
        this.username = jsonObject.getString("username");
        this.password = jsonObject.getString("password");
        this.department = jsonObject.getString("department");
    }

    /**
     * this method crates a json object of the object.
     * @return the jsonObject made
     */
    public JSONObject toJSONObject(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",this.username);
        jsonObject.put("password",this.password);
        jsonObject.put("department",this.department);
        return jsonObject;
    }


    /**
     * to sting for the employees
     * @return
     */
    @Override
    public String toString() {
        return username + " (" + department + ")";
    }
}
