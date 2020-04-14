package Data.classes;

import java.sql.*;

public class TrainersPerCourse {


    public void getTrainerPerCourseJava() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,\n"
                    + "       last_name\n"
                    + "FROM trainer\n"
                    + "JOIN trainer_per_course USING (trainer_id)\n"
                    + "JOIN course c USING (course_id)\n"
                    + "WHERE course_id = 1;");
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

    public void getTrainerPerCourseC() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,\n"
                    + "       last_name\n"
                    + "FROM trainer\n"
                    + "JOIN trainer_per_course USING (trainer_id)\n"
                    + "JOIN course c USING (course_id)\n"
                    + "WHERE course_id = 2;");
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

    public void getTrainerPerCourseBoth() {
        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT first_name,\n"
                    + "       last_name\n"
                    + "FROM trainer\n"
                    + "WHERE trainer_id = 5;");
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
