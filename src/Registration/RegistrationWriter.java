package Registration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationWriter {

    public static void save(StudentCourse regToCourse) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("StudentCourse.txt", true))) 
        {
            writer.write(
                    regToCourse.getRegistrationID() + ","
                    + regToCourse.getCourse() + ","
                    + regToCourse.getStudentID() + ","
                    + regToCourse.getStudentName() + ","
                    + regToCourse.getRegistrationDate() + ","
                    + regToCourse.getRegistrationTime()
            );

            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}