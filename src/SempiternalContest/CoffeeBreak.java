package SempiternalContest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeBreak {
    public static void main(String[] args) {
        int numberOfSlices;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("give all necessary information: " );
            try {
                numberOfSlices = scanner.nextInt();
                if(numberOfSlices<=0||numberOfSlices>=2*Math.pow(10,9)) throw new InputMismatchException();
            }
            catch(InputMismatchException e){
                System.out.println("Wrong number format. Please try again :)");
                continue;
            }
            scanner.close();
            break;
        }
        if(numberOfSlices==1) System.out.println(0);
        else System.out.println((numberOfSlices+1)/2);
    }
}
