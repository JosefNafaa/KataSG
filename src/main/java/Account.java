import exceptions.BanqueExceptions;

import java.util.ArrayList;
import java.util.Date;

public class Account {

    private Amount balance;
    private ArrayList<Statement> history;

    public Account() {
        balance = new Amount();
        history = new ArrayList<Statement>();

    }

    public int getBalance() {
        return this.balance.getCurrentAmount();
    }

    public int deposit(int amount) throws BanqueExceptions {
        if (amount < 0)
            throw new BanqueExceptions(MessageConstants.AMOUNT_DEPOSIT_WITHDRAWAL_NEGATIVE);

        this.balance.add(amount);
        Statement st = new Statement();
        st.setDate(new Date());
        st.setOperation(AccountConstants.DEPOSIT);
        st.setAmount(amount);
        st.setBalance(this.balance.getCurrentAmount());
        history.add(st);

        return this.balance.getCurrentAmount();
    }

    public int withraw(int amount) throws BanqueExceptions {

        if (amount < 0)
            throw new BanqueExceptions(MessageConstants.AMOUNT_DEPOSIT_WITHDRAWAL_NEGATIVE);

        if(amount>this.balance.getCurrentAmount())
            throw new BanqueExceptions(MessageConstants.WITHDRAWAL_AMOUNT_BIG_TO_BALANCE);
        this.balance.subtract(amount);
        Statement st = new Statement();
        st.setDate(new Date());
        st.setOperation(AccountConstants.WITHDRAWAL);
        st.setAmount(amount);
        st.setBalance(this.balance.getCurrentAmount());
        history.add(st);
        return this.balance.getCurrentAmount();
    }

    // Method permit to get history of operations
    public void getHistory() {
        if (null == history || history.isEmpty()) {
            System.out.println("History is empty");
        }
        history.forEach(System.out::println);
    }
}
