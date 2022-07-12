import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegrationCustomDurationTest {

    @Test
    public void getNumberOfDays_Test()
    {
        //same month test
        Assertions.assertEquals(1,CustomDuration.getNumberOfDays("2020-01-01","2020-01-01"));
        Assertions.assertEquals(15,CustomDuration.getNumberOfDays("2020-01-01","2020-01-15"));

        //same year test
        Assertions.assertEquals(30,CustomDuration.getNumberOfDays("2020-02-01","2020-03-01"));
        Assertions.assertEquals(29,CustomDuration.getNumberOfDays("2021-02-01","2021-03-01"));
        Assertions.assertEquals(365,CustomDuration.getNumberOfDays("2021-01-01","2021-12-31"));
        Assertions.assertEquals(366,CustomDuration.getNumberOfDays("2020-01-01","2020-12-31"));

        //different year test
        Assertions.assertEquals(366+365+31,CustomDuration.getNumberOfDays("2020-01-01","2022-01-31"));
        Assertions.assertEquals(366+(365*2),CustomDuration.getNumberOfDays("2020-01-01","2022-12-31"));
        Assertions.assertEquals((365*2),CustomDuration.getNumberOfDays("2021-01-01","2022-12-31"));


    }
}
