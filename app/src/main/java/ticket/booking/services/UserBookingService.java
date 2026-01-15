package ticket.booking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import ticket.booking.entities.Ticket;
import ticket.booking.entities.Train;
import ticket.booking.entities.User;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;
import ticket.booking.util.UserServiceUtil;


public class UserBookingService {
    private User user;
    private List<User> userList;
    private static final String USER_PATH = "D:\\IRCTC\\app\\src\\main\\java\\ticket\\booking\\LocalDb\\users.json";
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingService() throws IOException {
        loadUsers();
    }

    private void loadUsers() throws IOException {
        File users = new File(USER_PATH);
        userList= objectMapper.readValue(users, new TypeReference<List<User>>() {
        });
    }

    private void saveUsersToFile() throws IOException {
        File users = new File(USER_PATH);
        objectMapper.writeValue(users, userList);
    }

    public UserBookingService(User user) throws IOException {
        this.user = user;
        loadUsers();
    }

    public User loginUser(String name,String pass) {  // checks whether user is valid
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equals(name) && UserServiceUtil.checkPassword(pass, user1.getHashpassword());
        }).findFirst();
        //return user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashpassword());
        //        }).findFirst();
        return foundUser.orElse(null);
    }
    public void setLoggedInUser(User user) {
        this.user = user;
    }

    public Boolean signUp(User user) {
        try {
            userList.add(user);
            saveUsersToFile();
            return Boolean.TRUE;
        } catch (IOException e) {
            return Boolean.FALSE;
        }
    }

    public void fetchBookings() {
        if (user != null && !user.getTicketsbooked().isEmpty()) {
            System.out.println("--- Your Bookings ---");
            user.printTickets();
            System.out.println("---------------------");
        } else {
            System.out.println("You have no bookings.");
        }
    }

    public boolean cancelBooking(String ticketid) {
        if (ticketid == null || ticketid.isEmpty()) {
            return false;
        }
        boolean removed = user.getTicketsbooked().removeIf(ticket -> ticket.getTicketId().equals(ticketid));
        if (removed) {
            System.out.println("Ticket with ID " + ticketid + " has been canceled.");
            return Boolean.TRUE;
        } else {
            System.out.println("No ticket found with ID " + ticketid);
            return Boolean.FALSE;
        }
    }

    public List<Train> getTrains(String source, String destination) throws IOException {
        TrainService Ts = new TrainService();
        return Ts.searchTrain(source, destination);
    }

    public Ticket bookSeat(Train train,int row , int seat, String source, String destination) throws IOException {
        List<List<Integer>> list=train.getSeats();
        if(row>=0&&row<list.size()&&seat>=0&&seat<list.get(row).size()){
            if(list.get(row).get(seat)==0){
                list.get(row).set(seat,1);
                train.setSeats(list);
                String ticketId = UUID.randomUUID().toString();
                Ticket newTicket = new Ticket(ticketId, user.getUserId(),source, destination, "2025-09-05", train);
                this.user.getTicketsbooked().add(newTicket);
                for (int i = 0; i < userList.size(); i++) {
                    if (userList.get(i).getUserId().equals(this.user.getUserId())) {
                        userList.set(i, this.user);
                        break;
                    }
                }
                saveUsersToFile();
                System.out.println("Seat is booked successfully!!");
                return newTicket;
            }
            else{
                System.out.println("Seat is already booked.");
                return null;
            }
        }
        else{
            System.out.println("seat doesnt exist");
            return null;
        }
    }
    public List<List<Integer>> fetchSeats(Train train){
        return train.getSeats();
    }
    public void ticket(){
        List<Ticket> x=user.getTicketsbooked();
        for(Ticket t:x){
            System.out.println(t.getTicketId());
        }
    }

}
