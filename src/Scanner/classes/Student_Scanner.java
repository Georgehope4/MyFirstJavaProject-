package Scanner.classes;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Student_Scanner {

    public void createStudentByScanner() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("First, let's create your Students!");
        System.out.println(" ");
        System.out.println("Look the details as the example!");
        System.out.println("Georgios, Letsios, 27/11/1993, 2500");
        System.out.println(" ");
        System.out.println("How many Students would you like to create?");
        System.out.println("");
 
        while (true) {
            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
            System.out.print("Enter a number -> ");
            String input1 = sc.next();
            int intInputValue1;
            try {
                Connection con = DriverManager.getConnection(
                        connect, "root", "1234qwerQWER!@#$");

                Statement stmt = con.createStatement();
                intInputValue1 = Integer.parseInt(input1);

                for (int j = 0; j < Integer.parseInt(input1); j++) {
                    System.out.println("Give the First Name of" + " Student " + (j + 1) + ".");
                    String firstname = sc1.nextLine();
                    System.out.println("Give the Last Name of" + " Student " + (j + 1) + ".");
                    String lastname = sc1.nextLine();
                    System.out.println("Give the Date of Birth of Student(the format must be yyyy-MM-d).");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
                    LocalDate dateOfBirth;
                    while (true) {
                        String dateOfBirth1 = sc.next();
                        try {
                            dateOfBirth = LocalDate.parse(dateOfBirth1, formatter);
                            break;
                        } catch (Exception e) {
                            System.out.println("The format must be yyyy-MM-d!");
                            System.out.println("Please try again!");
                        }
                    }
                    double doublefee;
                    while (true) {
                        System.out.println("Give the Tution Fee of" + " Student " + (j + 1) + ".");
                        String fee = sc.next();

                        try {
                            doublefee = Double.parseDouble(fee);
                            break;
                        } catch (NumberFormatException ne) {
                            System.out.println("This is not a number");
                            System.out.println("Please try again!");
                        }
                    }
                    stmt.executeUpdate("Insert into student_scanner values ('" + (j + 1) + "','" + firstname + "','" + lastname + "','" + dateOfBirth + "','" + doublefee + "')");
                    System.out.println("The " + "Student " + (j + 1) + " is completed!");
                    System.out.println(" ");
                }
                ResultSet rs = stmt.executeQuery("select * from student_scanner");
                System.out.println("                                 <<<< List of Students >>>>");
                System.out.println(" ");
                System.out.println("Id/"  + "Title/" + "Stream/" + "Type/" + "Start Date/" + "End Date");
                System.out.println(" ");
                while (rs.next()) {
                    System.out.println(rs.getString(1) + ". " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("date_of_birth") + " " + rs.getString("tution_fees"));
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
