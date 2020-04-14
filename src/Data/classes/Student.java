package Data.classes;


import java.sql.*;

public class Student {

   
    //Method Get Students from DB
    public void getStudent() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            System.out.println("Id/" + "First Name/" + "Last Name/" + "Date Of Birth/" + "Tution Fees");
            System.out.println(" ");
            while (rs.next()) {
                System.out.println(rs.getString("student_id") + ". " + rs.getString("first_name") + " " + rs.getString("last_name") + " " + rs.getString("date_of_birth") + " " + rs.getString("tution_fees"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
