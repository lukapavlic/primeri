package si.unimb.lisa.tdd;

import org.junit.Assert;
import org.junit.Test;

public class SalaryCalculatorTest {

    @Test
    public void testCorrectSalaryCalculation() {
        SalaryCalculator sc=new SalaryCalculator(12.5,120,0.05);
        double expected=1575.0;
        Assert.assertEquals(sc.calculate(),expected,0.001);
    }

    @Test
    public void testWrongSalaryCalculation() {
        SalaryCalculator sc=new SalaryCalculator(12.5,120,0.05);
        double notExpected=1500.0;
        Assert.assertNotEquals(sc.calculate(),notExpected,0.001);
    }

}
