import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountParametrized {
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountParametrized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup(){
        account = new BankAccount("Franek", "Kowalski", 1000.00, BankAccount.CHECKING);

        System.out.println("Uruchamiam testy...");
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {542.21, true, 1542.21},
                {100.00, false, 1108.00},
                {200, true, 1300.00}
        });
    }

    @Test
    public void deposit(){
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(),0.1);




    }

}
