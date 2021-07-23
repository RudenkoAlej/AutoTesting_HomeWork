public class BankAccount {
    private long accountNumber;
    private float balance;

    public BankAccount() {
    }

    public BankAccount(int accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public long getAccountNuber() {
        return this.accountNumber;
    }

    public void setAccountNuber(long accountNuber) {
        this.accountNumber = accountNuber;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void credit(double moreMoney) {
        this.balance += moreMoney;
    }

    public void debit(double lessMoney) {
        if (this.balance - lessMoney < 0) {
            System.out.println("Сумма снятия больше чем остаток на счету!");
        } else {
            this.balance -= lessMoney;
        }

    }

    public String toString() {
        return "BankAccount with AccountNumber = " + this.accountNumber + " and Balance = " + this.balance;
    }
}
