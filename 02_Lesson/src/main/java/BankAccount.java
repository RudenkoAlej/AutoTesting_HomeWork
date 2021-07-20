public class BankAccount {

    private int accountNuber;
    private int balance;


    public BankAccount() {

    }

    public BankAccount(int accountNuber, int balance) {
        this.accountNuber = accountNuber;
        this.balance = balance;
    }

    public int getAccountNuber() {
        return accountNuber;
    }

    public void setAccountNuber(int accountNuber) {
        this.accountNuber = accountNuber;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    public int getBalance() {
        return balance;
    }

    public void credit(int moreMoney) {
        balance += moreMoney;
    }

    public void debit(int lessMoney) {
        if (balance-lessMoney < 0) {
            System.out.println("Сумма снятия больше чем остаток на счету!");
        } else {
            balance -= lessMoney;
        }
    }

    @Override
    public String toString() {
        return "BankAccount with " +
                "AccountNuber = " + accountNuber +
                " and Balance = " + balance;
    }
}
