package models;

public class CustomDate {
    private int year;
    private int month;
    private int day;

    public CustomDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static CustomDate createCustomDate(String fromDate) {
        String splits[]=fromDate.split("-");
        return new CustomDate(Integer.parseInt(splits[0]),Integer.parseInt(splits[1]),Integer.parseInt(splits[2]));
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean equals(CustomDate obj2)
    {
        return this.year==obj2.getYear() && this.month==obj2.getMonth() && this.day==obj2.getDay();
    }
}
