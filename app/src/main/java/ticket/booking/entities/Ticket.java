package ticket.booking.entities;

import java.util.Date;

public class Ticket {
    private  String ticketId;
    private  String userId;
    private  String source;
    private  String destination;
    private String date0fTravel;
    private Train train;

    public String TicketInfo(){
        return String.format("source %s destination %s userid %s ticketid %s date of travel %s",source,destination,userId,ticketId,date0fTravel);
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate0fTravel() {
        return date0fTravel;
    }

    public void setDate0fTravel(String date0fTravel) {
        this.date0fTravel = date0fTravel;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Ticket() {
    }

    public Ticket(String ticketId, String userId, String source, String destination, String date0fTravel, Train train) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.source = source;
        this.destination = destination;
        this.date0fTravel = date0fTravel;
        this.train = train;
    }
}
