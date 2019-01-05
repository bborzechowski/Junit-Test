import java.math.BigInteger;

public class BankAccount {
    private  String firstName;
    private String lastName;
    private double balance;

    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // jeśli klient wykonyje transakcje w oddziale z kasjerem, to branch = true;
    // jeśli klient wykonyje transakcje przez internet, branch = false;
    public double deposit(double amount, boolean branch){
        balance +=amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) throws IllegalAccessException{
        if(amount>500.00 && !branch){
            throw new IllegalAccessException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
    public boolean isChecking(){
        return accountType == CHECKING;
    }
}
