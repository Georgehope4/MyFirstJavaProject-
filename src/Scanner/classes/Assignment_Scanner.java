package Scanner.classes;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assignment_Scanner {

    public void createAssignmetByScanner() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Let's create your Assignments!");
        System.out.println(" ");
        System.out.println("Look the details as the example!");
        System.out.println("");
        System.out.println("How many Assignments would you like to create?");
        while (true) {
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
            System.out.print("Enter a number -> ");
            String input4 = sc.next();
            int intInputValue = 0;
            try {
                Connection con = DriverManager.getConnection(
                        connect, "root", "1234qwerQWER!@#$");

                Statement stmt = con.createStatement();
                intInputValue = Integer.parseInt(input4);

                for (int j = 0; j < Integer.parseInt(input4); j++) {
                    System.out.println("Give the Title of" + " Assignment" + (j + 1) + ".");
                    String title = sc1.nextLine();
                    System.out.println("Give the Description of" + " Assignment " + (j + 1) + ".");
                    String description = sc1.nextLine();
                    System.out.println("Give the Sub Date of Assignment(the format must be yyyy-MM-d).");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                    LocalDate subDate;

                    while (true) {
                        String subDate1 = sc.next();
                        try {
                            subDate = LocalDate.parse(subDate1, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d!");
                            System.out.println("Please try again!");
                        }
                    }
                    int oralMark;
                    while (true) {
                        System.out.println("Give the Oral Mark of " + " Assignment " + (j + 1) + ".");
                        String oral = sc.next();

                        try {
                              oralMark = Integer.parseInt(oral);
                            break;
                        } catch (NumberFormatException ne) {
                            System.out.println("This is not a number");
                            System.out.println("Please try again!");
                        }
                    }
                    int totalMark;
                    while (true) {
                        System.out.println("Give the Total Mark of " + " Assignment " + (j + 1) + ".");
                        String total = sc.next();

                        try {
                            totalMark = Integer.parseInt(total);
                            break;
                        } catch (NumberFormatException ne) {
                            System.out.println("This is not a number");
                            System.out.println("Please try again!");
                        }
                    }
                    stmt.executeUpdate("Insert into assignment_scanner values ('" + (j + 1) + "','" + title + "','" + description + "','" + subDate + "','" + oralMark + "','" + totalMark + "')");
                    System.out.println("The" + " Assignment " + (j + 1) + " is completed!");
                }
                ResultSet rs = stmt.executeQuery("select * from assignment_scanner");
                System.out.println("                                 <<<< List of Assignments >>>>");
                System.out.println(" ");
                System.out.println("Id/" + "Title/" + "Disciption/" + "Sub Date Time/" + "Oral Mark" + "Total Mark");
                System.out.println(" ");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
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
