public class Room {
    int number;
    RoomType type;
    int pricePerNight;

    public Room(int number, RoomType type, int pricePerNight) {
        this.number = number;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public String toString() {
        return "Room #" + number + " [" + type + "] - " + pricePerNight + "/night";
    }
}
