import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;


public class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    @BeforeClass  // metoda wykona sie raz na początku
    public static void beforeClass(){
        System.out.println("Test startuje, ładuje metodę BeforeClass " + count++);
    }

    @Before  // metoda wykona się jako pierwsza przed każdym testem
    public void setup(){
        bankAccount = new BankAccount("Bogdan","Nowak", 1000, BankAccount.CHECKING);

        System.out.println("Startuje test...");
    }

    @Test  // wykonuje testowanie
    public void deposit(){
       double balance = bankAccount.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @Test
    public void withdraw() throws IllegalAccessException{
        double balance = bankAccount.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    public void isCheckingTrue(){
        assertTrue("Konto nie jest CHEKING", bankAccount.isChecking());

    }

    @Test
    public void isNullTrue(){
        assertNotNull(bankAccount);
    }

    @After  // wykona się po każdym teście
    public void teardown(){
        System.out.println("Wykonałem test. " + count++);
    }

    @AfterClass  // wykona się raz po zakończonych testach
    public static void afterClass(){
        System.out.println("Zakończenie działania programu. AfterClass" );
    }





}
