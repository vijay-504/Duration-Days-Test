package models;

public enum Month {
    JANUARY(1,31,0),
    FEBRUARY(2,28,1),
    MARCH(3,31,0),
    APRIl(4,30,0),
    MAY(5,31,0),
    JUNE(6,30,0),
    JULY(7,31,0),
    AUGUST(8,31,0),
    SEPTEMBER(9,30,0),
    OCTOBER(10,31,0),
    NOVEMBER(11,30,0),
    DECEMBER(12,31,0);
    private int monthNumber;
    private int numberOfDays;
    private int daysToAddForLeapYear;

    public int getMonthNumber() {
        return monthNumber;
    }

    public int getNumberOfDays(int year) {
        int days=numberOfDays;
        if(year%4==0)
            days=days+getDaysToAddForLeapYear();
        return days;
    }

    public static int getDaysFromMonth(int monthOfYear,int year)
    {
        for(Month m:Month.values())
            if(m.getMonthNumber()==monthOfYear)
                return m.getNumberOfDays(year);
            throw new RuntimeException("Invalid input");
    }

    private int getDaysToAddForLeapYear() {
        return daysToAddForLeapYear;
    }



    Month(int monthNumber, int numberOfDays, int daysToAddForLeapYear) {
        this.monthNumber=monthNumber;
        this.numberOfDays=numberOfDays;
        this.daysToAddForLeapYear=daysToAddForLeapYear;
    }


}
