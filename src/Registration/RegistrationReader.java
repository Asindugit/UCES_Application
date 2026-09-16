package Registration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegistrationReader {

    public static void load(RegistrationHashTable registrationHashTable) {

        try (BufferedReader br = new BufferedReader(new FileReader("StudentCourse.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length >= 6) {

                    String registrationID = data[0].trim();
                    String course = data[1].trim();
                    String studentID = data[2].trim();
                    String studentName = data[3].trim();
                    String registrationDate = data[4].trim();
                    String registrationTime = data[5].trim();

                    StudentCourse studentCourse = new StudentCourse(registrationID,
                            course, studentID, studentName,
                            registrationDate, registrationTime);

                    registrationHashTable.addRegistration(studentCourse);
                }
            }

        } catch (IOException e) {
            System.out.println("StudentCourse.txt not found.");
        }
    }
}
