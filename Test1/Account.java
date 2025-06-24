import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Account implements AccountService {
    private final List<Transaction> transactions = new ArrayList<>();
    private int balance = 0;

    @Override
    public void deposit(int amount) {
        if (!validateAmount(amount)) return;

        balance += amount;
        transactions.add(new Transaction(amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (!validateAmount(amount)) return;

        if (amount > balance) {
            System.out.println("Retrait refusé : fonds insuffisants pour " + amount + " (solde actuel : " + balance + ")");
            return;
        }

        balance -= amount;
        transactions.add(new Transaction(-amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date       || Amount || Balance");
        ListIterator<Transaction> iterator = transactions.listIterator(transactions.size());
        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }

    private boolean validateAmount(int amount) {
        if (amount <= 0) {
            System.out.println("Montant invalide : " + amount + ". Il doit être > 0.");
            return false;
        }
        return true;
    }
}
