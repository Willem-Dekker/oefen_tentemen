import java.util.Date;

/**
 * Created by 436608 on 22-1-2018.
 */
public class Software_Ticket extends Ticket{
    protected String application;

    public Software_Ticket(String  date, Employee employee, String problem, String application) {
        super(date, employee, problem);
        this.application = application;
    }

    public String toString() {
        return "Ticket " + ticked_id + "(Hardwareticket, Application: " + application +
                "\n\tStatus: " + (solved?"Solved":"Open") +
                "\n\t" + employee.toString() + ": " + problem +
                (solved?"\n" + support_employee.toString() +": " + solution:"");
    }
}
