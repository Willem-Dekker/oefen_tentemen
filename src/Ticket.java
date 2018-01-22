import java.util.Date;

/**
 * Created by 436608 on 22-1-2018.
 */
abstract public class Ticket {
    private static int ID;
    protected int ticked_id;
    protected String  date;
    protected Employee employee;
    protected String problem;
    protected Support_Employee support_employee;
    protected String solution;
    protected boolean solved;

    public Ticket() {
    }

    public Ticket(String  date, Employee employee, String problem) {
        this.ticked_id = ++ID;
        this.date = date;
        this.employee = employee;
        this.problem = problem;
    }

    protected void solve_ticket(Support_Employee support_employee, String solution){
        this.support_employee = support_employee;
        this.solution = solution;
        this.solved = true;
    }

}
