import models.CustomDate;

public class CustomDuration {

    /*
    This method returns actual result and also it includes both(from and to) dates into result
     */
    public static int getNumberOfDays(String fromDate,String toDate)
    {
        CustomDate from=CustomDate.createCustomDate(fromDate);
        CustomDate to=CustomDate.createCustomDate(toDate);
        if(from.equals(to))
            return 1;
        return new DateCalculator().getDurationDays(from,to);

    }
}
