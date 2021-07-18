public class BankAccount {

    private int accountNuber;
    private int balance;


    public void setBalance(int balance) {
        this.balance = balance;
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


}
