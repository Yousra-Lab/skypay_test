public class User {
    int id;
    int balance;

    public User(int id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User #" + id + " - Balance: " + balance;
    }
}
