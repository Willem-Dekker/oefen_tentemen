import java.util.Date;

/**
 * Created by 436608 on 22-1-2018.
 */
public class Hardware_Ticket extends Ticket{
    private int computer_id;

    public Hardware_Ticket(String date, Employee employee, String problem, int computer_id) {
        super(date, employee, problem);
        this.computer_id = computer_id;
    }

    @Override
    public String toString() {
        return "Ticket " + ticked_id + "(Hardwareticket, computerId: " + computer_id +
                "\n\tStatus: " + (solved?"Solved":"Open") +
                "\n\t" + employee.toString() + ": " + problem +
                (solved?"\n" + support_employee.toString() +": " + solution:"");
    }
}
