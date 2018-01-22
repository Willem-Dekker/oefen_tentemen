import org.json.JSONArray;
import org.json.JSONString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by 436608 on 22-1-2018.
 */
public class Helpdesk {
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    public Helpdesk() {
    }

    public void addSupportEmployee(String username, String passord, String expertise){
        Support_Employee s = new Support_Employee(username,passord,expertise);
        employees.add(s);
    }

    public void loadEmployees(String filename){
        try{
            String jsonString = new String(Files.readAllBytes(Paths.get(filename)));
            //System.out.println(jsonString);
            JSONArray jsonArray = new JSONArray(jsonString);
            //System.out.println(jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                Employee e = new Employee(jsonArray.getJSONObject(i));
                employees.add(e);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printAllEmployees(){
        System.out.println("Employees:");
        for (Employee e:employees) {
            if (e instanceof Support_Employee) {
                Support_Employee s = (Support_Employee) e;
                System.out.println("\t" + s.toString());
            }else{
                System.out.println("\t" + e.toString());
            }
        }
    }

    public void printAllTickets(){
        System.out.println("Tickets");
        for (Ticket t:tickets) {
            if (t instanceof Hardware_Ticket){
                Hardware_Ticket h = (Hardware_Ticket) t;
                System.out.println(h.toString());
            }else{
                Software_Ticket s = (Software_Ticket) t;
                System.out.println(s.toString());
            }

        }
    }

    public void addTicket(String date, String username, String problem, int computer_ID){
        Employee e = getEmployeeByUsername(username);
        Hardware_Ticket h = new Hardware_Ticket(date,e,problem,computer_ID);
        tickets.add(h);
    }

    public void addTicket(String date, String username, String problem, String  aplication){
        Employee e = getEmployeeByUsername(username);
        Software_Ticket s = new Software_Ticket(date,e,problem,aplication);
        tickets.add(s);
    }

    private Ticket getTicketByID(int id){
        for (Ticket t: tickets) {
            if (t.ticked_id == id) {
                return t;
            }
        }
        return null;
    }

    private Employee getEmployeeByUsername(String username){
        for (Employee e: employees) {
            if (e.username.equals(username)){
                return e;
            }
        }
        return null;

    }

    public void solveTicket(int id, String username, String solution){
        Ticket ticket = getTicketByID(id);
        Support_Employee support_employee= (Support_Employee) getEmployeeByUsername(username);
        ticket.solve_ticket(support_employee,solution);
    }

}
