package Data.classes;

import Scanner.classes.Assignment_Scanner;
import Scanner.classes.Course_Scanner;
import Scanner.classes.Student_Scanner;
import Scanner.classes.Trainer_Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MainMenu {

    public static void createMenu() {

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("            <<<<Welcome to The Private International School of Athens!>>>>");
        System.out.println(" ");
        System.out.println("You have two otions: " + "\n" + "First Option--> If you want to use my Data, Press 1."
                + "\n" + "Second Option--> If you want to insert your Data about the private school, Press 2.  ");
        System.out.println("Your option is : ");
        int option;
        //I use the NumberException class, which is a method that allows only numbers.
        option = NumberException.FormatException();
        while (option < 1 || option > 2) {
            System.out.println("There are only two option.");
            System.out.println("!!Press 1 or 2!!");
            //I use again the NumberException class, which is a method that allows only numbers.
            option = NumberException.FormatException();
        }
        switch (option) {
            case 1:
                //The user will read my Data. 
                System.out.println("Please read the Data of the Private School.");
                System.out.println("----------------------------------------------------------------");
                System.out.println("Press 1, if you want to see the List of Students. ");
                System.out.println("Press 2, if you want to see the List of Courses. ");
                System.out.println("Press 3, if you want to see the List of Trainers. ");
                System.out.println("Press 4, if you want to see the List of Assignments. ");
                System.out.println("Press 5, if you want to see the Lists of Students per Course. ");
                System.out.println("Press 6, if you want to see the Lists of Trainers per Course. ");
                System.out.println("Press 7, if you want to see the Lists of Assignments per Course. ");
                System.out.println("Press 8, if you want to see the Lists of Assignments per Student. ");
                System.out.println("Press 9, if you want to see the Lists together. ");
                System.out.println("Press 10, EXIT");
                System.out.println("----------------------------------------------------------------");
                //I use again the NumberException class, which is a method that allows only numbers.
                option = NumberException.FormatException();
                while (option < 1 || option > 10) {
                    System.out.println("Please choose a right option.");
                    //I use again the NumberException class, which is a method that allows only numbers.
                    option = NumberException.FormatException();
                }
                while (option > 0 && option < 10) {
                    switch (option) {
                        case 1:
                            System.out.println("                                 <<<< List of Students >>>>");
                            System.out.print("\n");
                            Student s = new Student();
                            s.getStudent();

                            break;
                        case 2:
                            System.out.println("                                 <<<< List of Courses >>>>");
                            System.out.print("\n");
                            Course c = new Course();
                            c.getCourse();

                            break;
                        case 3:
                            System.out.println("                      <<<< List of Trainers >>>>");
                            System.out.print("\n");
                            Trainer t = new Trainer();
                            t.getTrainer();

                            break;
                        case 4:
                            System.out.println("                                        <<<< List of Assigbments >>>>");
                            System.out.print("\n");
                            Assignment a = new Assignment();
                            a.getAssignment();
                            break;
                        case 5:
                            System.out.println("****************************************************************");
                            System.out.println("                      <<<< Students per Course >>>>");
                            System.out.println(" ");
                            System.out.println("Press 1, if you want to see Students per Java Course. ");
                            System.out.println("Press 2, if you want to see Students per C# Course. ");
                            System.out.println("Press 3, if you want to see Students per Java & C# Course. ");
                            System.out.println("Or press any Number to go back.");
                            System.out.println("****************************************************************");
                            //I use again the NumberException class, which is a method that allows only numbers.
                            option = NumberException.FormatException();
                            while (option > 0 && option < 4) {
                                switch (option) {
                                    case 1:
                                        System.out.print("\n");
                                        System.out.println("---Java Course---");
                                        System.out.print("\n");
                                        StudentsPerCourse spc = new StudentsPerCourse();
                                        spc.getStudentPerCourseJava();
                                        break;
                                    case 2:
                                        System.out.print("\n");
                                        System.out.println("---C# Course---");
                                        System.out.print("\n");
                                        StudentsPerCourse spc1 = new StudentsPerCourse();
                                        spc1.getStudentPerCourseC();
                                        break;
                                    case 3:
                                        System.out.print("\n");
                                        System.out.println("---Java & C# Courses---");
                                        System.out.print("\n");
                                        StudentsPerCourse spc2 = new StudentsPerCourse();
                                        spc2.getStudentPerCourseBoth();
                                        break;
                                    default:
                                        break;
                                }
                                System.out.println(" ");
                                System.out.println("****************************************************************");
                                System.out.println("Press 1, if you want to see Students per Java Course. ");
                                System.out.println("Press 2, if you want to see Students per C# Course. ");
                                System.out.println("Press 3, if you want to see Students per Java & C# Course. ");
                                System.out.println("Or press any Number to go back.");
                                System.out.println("****************************************************************");
                                System.out.println("Look again the options and press the right number!");
                                //I use again the NumberException class, which is a method that allows only numbers.
                                option = NumberException.FormatException();
                            }
                            break;
                        case 6:
                            System.out.println("****************************************************************");
                            System.out.println("Press 1, if you want to see Trainers per Java Course. ");
                            System.out.println("Press 2, if you want to see  Trainers per C# Course. ");
                            System.out.println("Press 3, if you want to see Trainers per Java & C# Course. ");
                            System.out.println("Or press any Number to go back.");
                            System.out.println("****************************************************************");
                            System.out.println("Look again the options and press the right number!");
                            //I use again the NumberException class, which is a method that allows only numbers.
                            option = NumberException.FormatException();
                            while (option > 0 && option < 4) {
                                switch (option) {
                                    case 1:
                                        System.out.print("\n");
                                        System.out.println("---Java Course---");
                                        System.out.print("\n");
                                        TrainersPerCourse tpc = new TrainersPerCourse();
                                        tpc.getTrainerPerCourseJava();
                                        break;
                                    case 2:
                                        System.out.print("\n");
                                        System.out.println("---C# Course---");
                                        System.out.print("\n");
                                        TrainersPerCourse tpc1 = new TrainersPerCourse();
                                        tpc1.getTrainerPerCourseC();
                                        break;
                                    case 3:
                                        System.out.print("\n");
                                        System.out.println("---Java & C# Courses---");
                                        System.out.print("\n");
                                        TrainersPerCourse tpc2 = new TrainersPerCourse();
                                        tpc2.getTrainerPerCourseBoth();
                                        break;
                                    default:
                                        break;
                                }
                                System.out.println(" ");
                                System.out.println("****************************************************************");
                                System.out.println("Press 1, if you want to see Trainers per Java Course. ");
                                System.out.println("Press 2, if you want to see Trainers per C# Course. ");
                                System.out.println("Press 3, if you want to see Trainers per Java & C# Course. ");
                                System.out.println("Or press any Number to go back.");
                                System.out.println("****************************************************************");
                                System.out.println("Look again the options and press the right number!");
                                //I use again the NumberException class, which is a method that allows only numbers.
                                option = NumberException.FormatException();
                            }
                            break;
                        case 7:
                            System.out.println("****************************************************************");
                            System.out.println("Press 1, if you want to see Assignments per Java Course. ");
                            System.out.println("Press 2, if you want to see Assignments per C# Course. ");
                            System.out.println("Or press any Number to go back.");
                            System.out.println("****************************************************************");
                            System.out.println("Look again the options and press the right number!");
                            //I use again the NumberException class, which is a method that allows only numbers.
                            option = NumberException.FormatException();
                            while (option > 0 && option < 3) {
                                switch (option) {
                                    case 1:
                                        System.out.print("\n");
                                        System.out.println("---Assignments per Java Course---");
                                        System.out.print("\n");
                                        AssignmentsPerCourse apc = new AssignmentsPerCourse();
                                        apc.getAssignmentPerCourseJava();
                                        break;
                                    case 2:
                                        System.out.print("\n");
                                        System.out.println("---Assignments per C# Course---");
                                        System.out.print("\n");
                                        AssignmentsPerCourse apc1 = new AssignmentsPerCourse();
                                        apc1.getAssignmentPerCourseC();
                                        break;
                                    default:
                                        break;
                                }
                                System.out.println("\n");
                                System.out.println("****************************************************************");
                                System.out.println("Press 1, if you want to see Assignments per Java Course. ");
                                System.out.println("Press 2, if you want to see Assignments per C# Course. ");
                                System.out.println("Or press any Number to go back.");
                                System.out.println("****************************************************************");
                                System.out.println("Look again the options and press the right number!");
                                //I use again the NumberException class, which is a method that allows only numbers.
                                option = NumberException.FormatException();
                            }
                            break;

                        case 8:
                            System.out.println("****************************************************************");
                            System.out.println("Press 1, if you want to see Assignments per Java Students. ");
                            System.out.println("Press 2, if you want to see Assignments per C# Students. ");
                            System.out.println("Or press any Number to go back.");
                            System.out.println("****************************************************************");
                            System.out.println("Look again the options and press the right number!");
                            //I use again the NumberException class, which is a method that allows only numbers.
                            option = NumberException.FormatException();
                            while (option > 0 && option < 3) {
                                switch (option) {
                                    case 1:
                                        System.out.print("\n");
                                        System.out.println("---Assignments per Java Students---");
                                        System.out.print("\n");
                                        AssignmentsPerStudent aps = new AssignmentsPerStudent();
                                        aps.PrintStudentsPerCourseJavaPartAnB();
                                        break;
                                    case 2:
                                        System.out.print("\n");
                                        System.out.println("---Assignments per C# Students---");
                                        System.out.print("\n");
                                        AssignmentsPerStudent aps1 = new AssignmentsPerStudent();
                                        aps1.PrintStudentsPerCourseCPartAnB();
                                        break;
                                    default:
                                        break;
                                }
                                System.out.println("\n");
                                System.out.println("****************************************************************");
                                System.out.println("Press 1, if you want to see Assignments per Java Students. ");
                                System.out.println("Press 2, if you want to see Assignments per C# Students. ");
                                System.out.println("Or press any Number to go back.");
                                System.out.println("****************************************************************");
                                System.out.println("Look again the options and press the right number!");
                                //I use again the NumberException class, which is a method that allows only numbers.
                                option = NumberException.FormatException();
                            }
                            break;
                        case 9:
                            System.out.println("                                 <<<< List of Students >>>>");
                            System.out.print("\n");
                            Student s1 = new Student();
                            s1.getStudent();

                            System.out.println("                                 <<<< List of Courses >>>>");
                            System.out.print("\n");
                            Course c1 = new Course();
                            c1.getCourse();

                            System.out.println("                                 <<<< List of Trainers >>>>");
                            System.out.print("\n");
                            Trainer t1 = new Trainer();
                            t1.getTrainer();

                            System.out.println("                                 <<<< List of Assignments >>>>");
                            System.out.print("\n");
                            Assignment a1 = new Assignment();
                            a1.getAssignment();

                            System.out.print("\n");
                            System.out.println("                                 <<<< List of Students per Courses >>>>");
                            System.out.println("---Java Course---");
                            System.out.print("\n");
                            StudentsPerCourse spc1 = new StudentsPerCourse();
                            spc1.getStudentPerCourseJava();

                            System.out.print("\n");
                            System.out.println("---C# Course---");
                            System.out.print("\n");
                            spc1.getStudentPerCourseC();

                            System.out.print("\n");
                            System.out.println("---Java & C# Courses---");
                            System.out.print("\n");
                            spc1.getStudentPerCourseBoth();

                            System.out.print("\n");
                            System.out.println("                                 <<<< List of Trainers per Courses >>>>");
                            System.out.println("---Java Course---");
                            System.out.print("\n");
                            TrainersPerCourse tpc = new TrainersPerCourse();
                            tpc.getTrainerPerCourseJava();

                            System.out.print("\n");
                            System.out.println("---C# Course---");
                            System.out.print("\n");
                            TrainersPerCourse tpc1 = new TrainersPerCourse();
                            tpc1.getTrainerPerCourseC();

                            System.out.print("\n");
                            System.out.println("---Java & C# Courses---");
                            System.out.print("\n");
                            TrainersPerCourse tpc2 = new TrainersPerCourse();
                            tpc2.getTrainerPerCourseBoth();

                            System.out.print("\n");
                            System.out.println("                                 <<<< List of Assignments per Courses >>>>");
                            System.out.println("---Assignments per Java Course---");
                            System.out.print("\n");
                            AssignmentsPerCourse apc = new AssignmentsPerCourse();
                            apc.getAssignmentPerCourseJava();

                            System.out.print("\n");
                            System.out.println("---Assignments per C# Course---");
                            System.out.print("\n");
                            AssignmentsPerCourse apc1 = new AssignmentsPerCourse();
                            apc1.getAssignmentPerCourseC();

                            System.out.print("\n");
                            System.out.println("                                 <<<< List of Assignments per Students >>>>");
                            System.out.print("\n");
                            System.out.println("---Assignments per Java Students---");
                            System.out.print("\n");
                            AssignmentsPerStudent aps = new AssignmentsPerStudent();
                            aps.PrintStudentsPerCourseJavaPartAnB();

                            System.out.print("\n");
                            System.out.println("---Assignments per C# Students---");
                            System.out.print("\n");
                            AssignmentsPerStudent aps1 = new AssignmentsPerStudent();
                            aps1.PrintStudentsPerCourseCPartAnB();
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n");
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Press 1, if you want to see the List of Students. ");
                    System.out.println("Press 2, if you want to see the List of Courses. ");
                    System.out.println("Press 3, if you want to see the List of Trainers. ");
                    System.out.println("Press 4, if you want to see the List of Assignments. ");
                    System.out.println("Press 5, if you want to see the Lists of Students per Course. ");
                    System.out.println("Press 6, if you want to see the Lists of Trainers per Course. ");
                    System.out.println("Press 7, if you want to see the Lists of Assignments per Course. ");
                    System.out.println("Press 8, if you want to see the Lists of Assignments per Student. ");
                    System.out.println("Press 9, if you want to see the Lists together. ");
                    System.out.println("Press 10, EXIT");
                    System.out.println("----------------------------------------------------------------");

                    System.out.println("Look again the options and press the right number!");
                    //I use again the NumberException class, which is a method that allows only numbers.
                    option = NumberException.FormatException();
                    while (option < 1 || option > 10) {
                        System.out.println("Please choose a right option.");
                        //I use again the NumberException class, which is a method that allows only numbers.
                        option = NumberException.FormatException();
                    }
                }
                System.out.println("Bye Bye!!!!");
                break;
            case 2:
                //The user will create his/her Data.
                System.out.println("                             ****Please,insert your Own Data.**** ");
                System.out.println(" ");
                System.out.println("Follow the Instructions!");

                //The user create his/her Students.
                Student_Scanner ss = new Student_Scanner();
                ss.createStudentByScanner();

                //The user create his/her Courses.
                Course_Scanner cs = new Course_Scanner();
                cs.createCourseByScanner();

                //The user create his/her Trainers.
                Trainer_Scanner ts = new Trainer_Scanner();
                ts.createTrainerByScanner();

                //The user create his/her Assignments.
                Assignment_Scanner as = new Assignment_Scanner();
                as.createAssignmetByScanner();
                System.out.println(" ");
                
                System.out.println("You have two otions: " + "\n" + "First Option--> If you want to keep your Data, Press 1."
                        + "\n" + "Second Option--> If you want to delete your Data about the private school, Press 2.  ");
                System.out.println("Your option is : ");
                option = NumberException.FormatException();
                while (option > 0 && option < 3) {
                    switch (option) {
                        case 1:

                            System.out.println(" ");
                            System.out.println("----------------------------------------------------------------");
                            System.out.println("You have just completed your data!");
                            System.out.println("!!!Congratulatios!!!!");
                            System.out.println("!!!Bye Bye!!!");
                            break;

                        case 2:
                            String connect = "jdbc:mysql://localhost:3306/private_school_scanner?zeroDateTimeBehavior=CONVERT_TO_NULL&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
                            try {

                                Connection con = DriverManager.getConnection(
                                        connect, "root", "1234qwerQWER!@#$");
                                Statement stmt = con.createStatement();

                                String sql = "DELETE FROM student_scanner";
                                String sql1 = "DELETE FROM course_scanner";
                                String sql2 = "DELETE FROM trainer_scanner";
                                String sql3 = "DELETE FROM assignment_scanner";
                                stmt.executeUpdate(sql);
                                stmt.executeUpdate(sql1);
                                stmt.executeUpdate(sql2);
                                stmt.executeUpdate(sql3);

                                System.out.println(" ");
                                con.close();
                            } catch (Exception e) {
                                System.out.println(e);

                            }
                            System.out.println("!!!Congratulatios!!!!");
                            System.out.println("!!!Bye Bye!!!");
                            break;
                    }
                    break;
                }

        }
    }
}
