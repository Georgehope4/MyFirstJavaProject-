package Data.classes;

import java.sql.*;

public class Assignment {

    // Method Get Assignments from DB
    public void getAssignment() {

        String connect = "jdbc:mysql://localhost:3306/private_school?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
        try {

            Connection con = DriverManager.getConnection(
                    connect, "root", "1234qwerQWER!@#$");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from assignment");
            System.out.println("Id/" + "Title/" + "Disciption/" + "Sub Date Time/" + "Oral Mark" + "Total Mark");
            while (rs.next()) {
                System.out.println(rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
