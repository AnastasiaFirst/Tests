import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testCalcAndShowTaxes() {
        //given
        Main main = new Main();
        //when
        String result = Main.calcAndShowTaxes(1000, 200); //Проверка на правильность расчета
        //then
        Assertions.assertEquals("УСН доходы", result); //Ожидаем положительный результат
    }

    @Test
    public void testCalcTax15() {
        //given
        Main main = new Main();
        //when
        int result = Main.calcTax15(1000,0); //Проверка на правильность расчета
        //then
        Assertions.assertNotEquals(1, result); //Ожидаем отрицательный результат
    }

    @Test
    public void testСalcTax6() {
        //given
        Main main = new Main();
        //when
        int result = Main.calcTax6(100); //Проверка на пустое значения
        //String[] result = Main.main({"1","2"});
        //then
        Assertions.assertNull(result); //Ожидаем отрицательный результат
    }
}