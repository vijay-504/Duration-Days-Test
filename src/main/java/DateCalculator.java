import models.CustomDate;
import models.Month;

public class DateCalculator {


    public int getDaysFromStartDayOfYearToTillGivenDate(int monthOfYear,int dayOfMonth,int year)
    {
        int days=dayOfMonth;
        for(int i=1;i<monthOfYear;i++)
            days=days+ Month.getDaysFromMonth(i,year);
        return days;
    }

    public int getDaysFromGivenDateToTillEndOfYear(int monthOfYear,int dayOfMonth,int year)
    {
        int days= Month.getDaysFromMonth(monthOfYear,year)-dayOfMonth+1;
        for(int i=monthOfYear+1;i<=12;i++)
            days=days+ Month.getDaysFromMonth(i,year);
        return days;
    }

    public int getDaysBetweenTwoYearsExclusive(int fromYear,int toYear)
    {
        int years=toYear-fromYear-1;

        if(years<=0)
            return 0;
        int numberOfDays=years*365;
        int startYear=fromYear+1;
        int endYear=toYear-1;
        int firstLeapYearInDuration=getNextLeapYear(startYear);
        if(firstLeapYearInDuration>endYear)
            return numberOfDays;
        int lastLeapYearInDuration=getPreviousLeapYear(endYear);
        int leapYearsCount=(lastLeapYearInDuration/4 )-(firstLeapYearInDuration/4)+1;
        return numberOfDays+leapYearsCount;

    }

    public  int getPreviousLeapYear(int toYear) {
        if(toYear%4==0)
            return toYear;
        return (4*(toYear/4));

    }

    public int getNextLeapYear(int fromYear) {
        if(fromYear%4==0)
            return fromYear;
        return (4*(fromYear/4))+4;

    }

    public int getDaysInSameYear(CustomDate from, CustomDate to) {
        int year=from.getYear();
        int fromMonth=from.getMonth();
        int toMonth=to.getMonth();
        if(fromMonth==toMonth)
            return to.getDay()-from.getDay()+1;
        else
        {
            int numberOfdays=Month.getDaysFromMonth(fromMonth,year)-from.getDay()+1;
            numberOfdays=numberOfdays+to.getDay();
            for(int i=fromMonth+1;i<toMonth;i++)
                numberOfdays=numberOfdays+Month.getDaysFromMonth(i,year);
            return numberOfdays;
        }

    }

    public int getDurationDays(CustomDate from, CustomDate to) {
        if(from.getYear()==to.getYear())
        return getDaysInSameYear(from,to);
        else
        {
            int numberOfDays=getDaysFromGivenDateToTillEndOfYear(from.getMonth(),from.getDay(),from.getYear());
            numberOfDays=numberOfDays+getDaysFromStartDayOfYearToTillGivenDate(to.getMonth(),to.getDay(),to.getYear());
            numberOfDays=numberOfDays+getDaysBetweenTwoYearsExclusive(from.getYear(),to.getYear());
            return numberOfDays;

        }
    }
}
