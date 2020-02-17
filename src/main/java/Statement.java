import java.util.Date;

public class Statement {

    private String operation;
    private Date date;
    private int amount;
    private int balance;

    public Statement(String operation, Date date, int amount, int balance) {
        this.operation = operation;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Statement() {

    }

    public String getOperation() {
        return operation;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    public Date getDate() {
        return date;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "operation='" + operation + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", balance=" + balance +
                '}';
    }
}
