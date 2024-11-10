import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void calcAndShowTaxes() {
        //given
        Main main = new Main();
        //when
        String result = Main.calcAndShowTaxes(1000, 200);
        //then
        Assertions.assertEquals("УСН доходы", result);
    }

    @Test
    public void calcTax15() {
        //given
        Main main = new Main();
        //when
        int result = Main.calcTax15(1000,0);
        //then
        Assertions.assertNotEquals(0, result);
    }

    @Test
    public static void main() {
        //given
        Main main = new Main();
        //when
        String[] stringArray = new String[] {"1", "2"};
        //String[] result = Main.main({"1","2"});
        //then
        Assertions.assertNull(stringArray);
    }
}