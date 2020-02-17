public class Amount {
    public int amount;

    public Amount() {
        amount = 0;
    }
    public Amount(int amount) {
        this.amount = amount;
    }
    public int add(int amount) {
        return this.amount += amount;
    }

    public int subtract(int amount) {
        return this.amount -= amount;
    }

    public int  getCurrentAmount() {
        return this.amount;
    }

}
