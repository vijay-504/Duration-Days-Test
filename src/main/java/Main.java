import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the from date in format(YYYY-MM-DD : ");
        String fromDate=sc.nextLine();
        System.out.println("Enter the to date in format(YYYY-MM-DD : ");
        String toDate=sc.nextLine();
        System.out.println("Duration between these days incluing both dates :"+ CustomDuration.getNumberOfDays(fromDate,toDate));
    }
}
