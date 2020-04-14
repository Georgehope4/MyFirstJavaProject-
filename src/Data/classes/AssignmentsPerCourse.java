package Data.classes;

import java.sql.*;

public class AssignmentsPerCourse {

    public void getAssignmentPerCourseJava() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title\n"
                    + "FROM Assignment\n"
                    + "WHERE course_id = 1;");
            System.out.println("Title");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAssignmentPerCourseC() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT title\n"
                    + "FROM Assignment\n"
                    + "WHERE course_id = 2;");
            System.out.println("Title");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
