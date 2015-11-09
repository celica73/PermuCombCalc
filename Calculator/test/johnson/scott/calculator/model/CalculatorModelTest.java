package johnson.scott.calculator.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorModelTest {
    private CalculatorModel cm;
    
    public static final long C10_2 = 45;
    public static final long C10_8 = 45;
    public static final long C15_7 = 6435;
    public static final long P10_2 = 90;
    public static final long P10_8 = 1814400;
    public static final long P10_0 = 1;
    public static final double ERROR = 0.000001;
    @Before
    public void setUp() throws Exception {
        cm = new CalculatorModel();
    }

    @Test
    public void testParseLine() {
        cm.parseLine("P 10 0");
        assertEquals(P10_0, cm.getAnswer(),ERROR);
        cm.parseLine("P 10 8");
        assertEquals(P10_8, cm.getAnswer(),ERROR);
        cm.parseLine("P 10 2");
        assertEquals(P10_2, cm.getAnswer(),ERROR);
        cm.parseLine("C 10 8");
        assertEquals(C10_8, cm.getAnswer(),ERROR);
        cm.parseLine("C 15 7");
        assertEquals(C15_7, cm.getAnswer(),ERROR);
        cm.parseLine("C 10 2");
        assertEquals(C10_2, cm.getAnswer(),ERROR);
    }
}
