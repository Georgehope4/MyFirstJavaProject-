package Data.classes;

import java.sql.*;

public class StudentsPerCourse {

    public void getStudentPerCourseJava() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,\n"
                    + "       last_name,\n"
                    + "       c.title\n"
                    + "FROM student\n"
                    + "JOIN student_per_course USING (student_id)\n"
                    + "JOIN course c USING (course_id)\n"
                    + "WHERE c.title = 'Java';");
            System.out.println("First Name/" + "Last Name");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStudentPerCourseC() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,\n"
                    + "       last_name,\n"
                    + "       c.title\n"
                    + "FROM student\n"
                    + "JOIN student_per_course USING (student_id)\n"
                    + "JOIN course c USING (course_id)\n"
                    + "WHERE c.title = 'C#';");
            System.out.println("First Name/" + "Last Name");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getStudentPerCourseBoth() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,\n"
                    + "       last_name\n"
                    + "FROM student\n"
                    + "WHERE student_id = 10;");
            System.out.println("First Name/" + "Last Name");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
