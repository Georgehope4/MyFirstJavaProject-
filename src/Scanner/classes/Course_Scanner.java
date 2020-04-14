package Scanner.classes;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Course_Scanner {

    public void createCourseByScanner() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Let's create your Courses!");
        System.out.println(" ");
        System.out.println("Look the details as the example!");
        System.out.println("Java, Coding Bootcamp, Full-Time, 2019-10-01, 2020-05-31");
        System.out.println(" ");
        System.out.println("How many Courses would you like to create?");
        System.out.println(" ");

        while (true) {
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
            System.out.print("Enter a number --> ");
            String input2 = sc.next();
            int numberCourses;
            try {
                 Connection con = DriverManager.getConnection(
                        connect, "root", "1234qwerQWER!@#$");

                Statement stmt = con.createStatement();
                numberCourses = Integer.parseInt(input2);

                for (int j = 0; j < numberCourses; j++) {
                    System.out.println("Give the Title of" + " Course " + (j + 1) + ".");
                    String title = sc1.nextLine();
                    System.out.println("Give the Stream (for example: Coding Bootcamp) of" + " Course" + (j + 1) + ".");
                    String stream = sc1.nextLine();
                    System.out.println("Give the Type (for Example: Full Time, Part Time) of" + " Course" + (j + 1) + ".");
                    String type = sc1.nextLine();
                    System.out.println("Give the Start Date of Courese (the format must be yyyy-MM-d)");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                    LocalDate startDate;
                    while (true) {
                        String startDate1 = sc.next();
                        try {
                            startDate = LocalDate.parse(startDate1, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d!");
                            System.out.println("Please try again!");
                        }
                    }
                    System.out.println("Give the End Date of Courese (the format must be yyyy-MM-d).");
                    LocalDate endDate;
                    while (true) {
                        String endDate1 = sc.next();
                        try {
                            endDate = LocalDate.parse(endDate1, formatter);
                            if (endDate.isAfter(startDate)) {
                                break;
                            } else {
                                System.out.println("Wrong End Date, please insert an older End Date than Start Date.");
                            }
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d!");
                            System.out.println("Please try again!");
                        }
                    }
                    stmt.executeUpdate("Insert into course_scanner values ('" + (j + 1) + "','" + title + "','" + stream + "','" + type + "','" + startDate + "','" + endDate + "')");
                    System.out.println("The " + "Course " + (j + 1) + " is completed!");
                    System.out.println(" ");
                }
                ResultSet rs = stmt.executeQuery("select * from course_scanner");
                System.out.println("                                 <<<< List of Courses >>>>");
                System.out.println(" ");
                System.out.println("Id/" + "First Name/" + "Last Name/" + "Date Of Birth/" + "Tution Fees");
                System.out.println(" ");
                while (rs.next()) {
                     System.out.println(rs.getString(1)+ ". " + rs.getString(2) + " " + rs.getString(3) + " "+ rs.getString(4) + " " + rs.getString(5));
                     System.out.println("");
                }
                con.close();
                break;
            } catch (NumberFormatException ne) {
                System.out.println("This is not a number.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
