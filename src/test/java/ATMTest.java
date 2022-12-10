import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task1.Handler;
import task1.Handler20;
import task1.Handler5;
import task1.Handler50;

public class ATMTest {
    @Test
    public void ATMTests() {
        Handler handler5 = new Handler5();
        Handler handler20 = new Handler20();
        Handler handler50 = new Handler50();

        handler50.setNext(handler20);
        handler20.setNext(handler5);

        // Check if the ATM is able to provide a certain amount of money
        Assertions.assertEquals(handler50.process(125), true);

        boolean flag = true;
        try {
            handler50.process(126);
        } catch (IllegalArgumentException e){
            flag = false;
        }
        Assertions.assertFalse(flag);
    }
}