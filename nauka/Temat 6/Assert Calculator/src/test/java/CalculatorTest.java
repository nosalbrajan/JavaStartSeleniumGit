import org.junit.Test;

import static junit.framework.TestCase.*;

public class CalculatorTest {

    public static final int firstNumber = 5;
    public static final int secondNumber = 6;

    Calculator cl = new Calculator();

    public static final int firstResult= 12;
    public static final int secondResult= 11;

    @Test
    public void testCase1() {
        int actaulResult = cl.add(firstNumber, secondNumber);
        assertTrue(secondResult==actaulResult);
    }

    @Test
    public void testCase2(){
        int actaulResult = cl.add(firstNumber, secondNumber);
        assertFalse(firstResult==actaulResult);
    }

    @Test
    public void testCase3(){
        int actaulResult = cl.add(firstNumber, secondNumber);
        assertEquals(firstNumber,secondNumber);
    }


}
