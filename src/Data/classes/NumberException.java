package Data.classes;

import java.util.Scanner;

public class NumberException {
    
    public static int FormatException() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String optionString = sc.next();
            int option;
            try {
                option = Integer.parseInt(optionString);
                return option;

            } catch (NumberFormatException e) {
                System.out.println("****Please write only numbers!!****");
                System.out.println("Please try again!");
            }

        }

    }
}
