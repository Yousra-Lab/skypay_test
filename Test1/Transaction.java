import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String date;
    private final int amount;
    private final int balance;

    public Transaction(int amount, int balance) {
        this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("%s || %d || %d", date, amount, balance);
    }
}
