package Scanner.classes;

import java.sql.*;
import java.util.Scanner;

public class Trainer_Scanner {

    public void createTrainerByScanner() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Let's create your Trainers!");
        System.out.println(" ");
        System.out.println("Look the details as the example!");
        System.out.println("George, Letsios, Java");
        System.out.println(" ");
        System.out.println("How many Trainers would you like to create?");
        System.out.println(" ");

        while (true) {
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
            System.out.print("Enter a number -> ");
            String input3 = sc.next();
            int intInputValue = 0;
            try {
                Connection con = DriverManager.getConnection(
                        connect, "root", "1234qwerQWER!@#$");

                Statement stmt = con.createStatement();
                intInputValue = Integer.parseInt(input3);

                for (int j = 0; j < Integer.parseInt(input3); j++) {
                    System.out.println("Give the First Name of" + " Trainer " + (j + 1) + ".");
                    String firstname = sc1.nextLine();
                    System.out.println("Give the Last Name of" + " Trainer " + (j + 1) + ".");
                    String lastname = sc1.nextLine();
                    System.out.println("Give the Subject of" + " Trainer " + (j + 1) + ".");
                    String subject = sc1.nextLine();

                    stmt.executeUpdate("Insert into trainer_scanner values ('" + (j + 1) + "','" + firstname + "','" + lastname + "','" + subject + "')");
                    System.out.println("The" + " Trainer " + (j + 1) + " is completed!");
                }
                ResultSet rs = stmt.executeQuery("select * from trainer_scanner");
                System.out.println("                                 <<<< List of Trainers >>>>");
                System.out.println(" ");
                System.out.println("Id/" + "First Name/" + "Last Name/" + "Subject");
                System.out.println(" ");
                while (rs.next()) {
                     System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
                     System.out.println(" ");
                }
                con.close();
                break;
            } catch (NumberFormatException ne) {
                System.out.println("This is not a number");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
}
