import java.util.*;
import java.text.*;

public class Service {
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        for (Room r : rooms) {
            if (r.number == roomNumber) return; 
        }
        rooms.add(new Room(roomNumber, roomType, roomPricePerNight));
    }


    public void setUser(int userId, int balance) {
        for (User u : users) {
            if (u.id == userId) return; 
        }
        users.add(new User(userId, balance));
    }


    public void bookRoom(int userId, int roomNumber, Date checkIn, Date checkOut) {
        if (checkOut.before(checkIn)) {
            System.out.println("Erreur : check-out avant check-in.");
            return;
        }

        User user = null;
        for (User u : users) if (u.id == userId) user = u;
        Room room = null;
        for (Room r : rooms) if (r.number == roomNumber) room = r;

        if (user == null || room == null) {
            System.out.println("Utilisateur ou chambre introuvable.");
            return;
        }

        // Vérifier conflit
        for (Booking b : bookings) {
            if (b.roomSnapshot.number == roomNumber &&
                !(checkOut.before(b.checkIn) || checkIn.after(b.checkOut))) {
                System.out.println("Conflit : chambre déjà réservée.");
                return;
            }
        }

        long days = (checkOut.getTime() - checkIn.getTime()) / (1000 * 60 * 60 * 24);
        int cost = (int) days * room.pricePerNight;

        if (user.balance < cost) {
            System.out.println("Solde insuffisant pour la réservation.");
            return;
        }

        user.balance -= cost;
        bookings.add(0, new Booking(room, user, checkIn, checkOut, cost));
        System.out.println("Réservation réussie !");
    }

    public void printAll() {
        System.out.println("=== Chambres ===");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            System.out.println(rooms.get(i));
        }

        System.out.println("\n=== Réservations ===");
        for (Booking b : bookings) {
            System.out.println(b);
        }
    }

    public void printAllUsers() {
        System.out.println("=== Utilisateurs ===");
        for (int i = users.size() - 1; i >= 0; i--) {
            System.out.println(users.get(i));
        }
    }
}
