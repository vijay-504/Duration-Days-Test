import models.CustomDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateCalculatorTest {

    DateCalculator calculator;
    @BeforeEach
    public void init()
    {
        calculator=new DateCalculator();
    }

    @Test
    public void getDaysFromStartDayOfYearToTillGivenDate_Test()
    {
        Assertions.assertEquals(29,calculator.getDaysFromStartDayOfYearToTillGivenDate(1,29,2022));
        Assertions.assertEquals(60,calculator.getDaysFromStartDayOfYearToTillGivenDate(3,1,2003));
        Assertions.assertEquals(61,calculator.getDaysFromStartDayOfYearToTillGivenDate(3,1,2004));
        Assertions.assertEquals(366,calculator.getDaysFromStartDayOfYearToTillGivenDate(12,31,2004));
        Assertions.assertEquals(365,calculator.getDaysFromStartDayOfYearToTillGivenDate(12,31,2003));

    }

    @Test
    public void getDaysFromGivenDateToTillEndOfYear_Test()
    {
        Assertions.assertEquals(3,calculator.getDaysFromGivenDateToTillEndOfYear(12,29,2022));
        Assertions.assertEquals(334,calculator.getDaysFromGivenDateToTillEndOfYear(2,1,2003));
        Assertions.assertEquals(335,calculator.getDaysFromGivenDateToTillEndOfYear(2,1,2004));
        Assertions.assertEquals(366,calculator.getDaysFromGivenDateToTillEndOfYear(1,1,2004));
        Assertions.assertEquals(365,calculator.getDaysFromGivenDateToTillEndOfYear(1,1,2003));

    }

    @Test
    public void getDaysBetweenTwoYearsExclusive_Test()
    {
        Assertions.assertEquals(0,calculator.getDaysBetweenTwoYearsExclusive(2000,2000));
        Assertions.assertEquals(0,calculator.getDaysBetweenTwoYearsExclusive(2000,2001));
        Assertions.assertEquals(365,calculator.getDaysBetweenTwoYearsExclusive(2000,2002));
        Assertions.assertEquals(366,calculator.getDaysBetweenTwoYearsExclusive(2003,2005));
        Assertions.assertEquals(365*3,calculator.getDaysBetweenTwoYearsExclusive(2000,2004));
        Assertions.assertEquals((365*7)+(366*2),calculator.getDaysBetweenTwoYearsExclusive(2000,2010));

    }

    @Test
    public void getPreviousLeapYear_Test()
    {
        Assertions.assertEquals(2000,calculator.getPreviousLeapYear(2001));
        Assertions.assertEquals(2000,calculator.getPreviousLeapYear(2002));
        Assertions.assertEquals(2000,calculator.getPreviousLeapYear(2003));
        Assertions.assertEquals(2000,calculator.getPreviousLeapYear(2000));
    }

    @Test
    public void getNextLeapYear_Test()
    {
        Assertions.assertEquals(2004,calculator.getNextLeapYear(2001));
        Assertions.assertEquals(2004,calculator.getNextLeapYear(2002));
        Assertions.assertEquals(2004,calculator.getNextLeapYear(2003));
        Assertions.assertEquals(2000,calculator.getNextLeapYear(2000));
    }

    @Test
    public void getDaysInSameYear_Test()
    {
        Assertions.assertEquals(2,calculator.getDaysInSameYear(new CustomDate(2000,1,1),new CustomDate(2000,1,2)));
        Assertions.assertEquals(30,calculator.getDaysInSameYear(new CustomDate(2000,02,1),new CustomDate(2000,03,01)));
        Assertions.assertEquals(29,calculator.getDaysInSameYear(new CustomDate(2001,02,1),new CustomDate(2001,03,01)));
        Assertions.assertEquals(365,calculator.getDaysInSameYear(new CustomDate(2001,01,1),new CustomDate(2001,12,31)));
        Assertions.assertEquals(366,calculator.getDaysInSameYear(new CustomDate(2000,01,1),new CustomDate(2000,12,31)));

    }

    @Test
    public void getDurationDays_Test()
    {
        Assertions.assertEquals(2,calculator.getDurationDays(new CustomDate(2000,1,1),new CustomDate(2000,1,2)));
        Assertions.assertEquals(30,calculator.getDurationDays(new CustomDate(2000,02,1),new CustomDate(2000,03,01)));
        Assertions.assertEquals(29,calculator.getDurationDays(new CustomDate(2001,02,1),new CustomDate(2001,03,01)));
        Assertions.assertEquals(365,calculator.getDurationDays(new CustomDate(2001,01,1),new CustomDate(2001,12,31)));
        Assertions.assertEquals(366,calculator.getDurationDays(new CustomDate(2000,01,1),new CustomDate(2000,12,31)));
        Assertions.assertEquals(365+366,calculator.getDurationDays(new CustomDate(2000,1,1),new CustomDate(2001,12,31)));
        Assertions.assertEquals((365*2)+366,calculator.getDurationDays(new CustomDate(2000,1,1),new CustomDate(2002,12,31)));
        Assertions.assertEquals(365+31+31,calculator.getDurationDays(new CustomDate(2000,12,1),new CustomDate(2002,01,31)));



    }
}
