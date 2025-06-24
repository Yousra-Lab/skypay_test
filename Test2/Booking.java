import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    Room roomSnapshot;
    User userSnapshot;
    Date checkIn;
    Date checkOut;
    int totalPrice;

    public Booking(Room room, User user, Date checkIn, Date checkOut, int totalPrice) {
        this.roomSnapshot = new Room(room.number, room.type, room.pricePerNight);
        this.userSnapshot = new User(user.id, user.balance);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Booking: Room " + roomSnapshot.number + " by User " + userSnapshot.id +
                " from " + sdf.format(checkIn) + " to " + sdf.format(checkOut) +
                " | Price: " + totalPrice;
    }
}
