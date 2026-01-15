package ticket.booking.entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private String hashpassword;
    private List<Ticket> ticketsbooked;
    private String userId;

    public void printTickets(){
        for(int i=0;i<ticketsbooked.size();i++){
            System.out.println(ticketsbooked.get(i).TicketInfo());
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashpassword() {
        return hashpassword;
    }

    public void setHashpassword(String hashpassword) {
        this.hashpassword = hashpassword;
    }

    public List<Ticket> getTicketsbooked() {
        return ticketsbooked;
    }

    public void setTicketsbooked(List<Ticket> ticketsbooked) {
        this.ticketsbooked = ticketsbooked;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public User(String userId, List<Ticket> ticketsbooked, String hashpassword, String password, String name) {
        this.userId = userId;
        this.ticketsbooked = ticketsbooked;
        this.hashpassword = hashpassword;
        this.password = password;
        this.name = name;
    }

}
