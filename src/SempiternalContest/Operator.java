package SempiternalContest;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Operator {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int perMonthCost,perMonthInternet, perMbCost,nextMonthInternet;
        while(true) {
                System.out.println("give all necessary information: " );
            try {
                perMonthCost = scanner.nextInt();
                perMonthInternet = scanner.nextInt();
                perMbCost = scanner.nextInt();
                nextMonthInternet = scanner.nextInt();
                if(nextMonthInternet>100||perMonthCost<=0||perMonthInternet<0||perMbCost<0||nextMonthInternet<0)
                    throw  new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Wrong number format. All numbers should to be positive and nextMonthInternet shouldn't be >100.\n  Please try again :)");
                scanner.next();
                continue;
            }
            break;
        }
        int totalCost = (perMonthInternet > nextMonthInternet) ? perMonthCost : perMonthCost+(nextMonthInternet-perMonthInternet)*perMbCost;
        System.out.println("Total cost of internet on next month: "+ totalCost );
    }
}
