package Student_Manage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private final String FileName = "Courses.txt";

    // Get only course names ---------------------------------------------------
    public List<String> getCourseNames() {

        List<String> courseNames = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 2) {
                    courseNames.add(data[1].trim());
                }
            }

        } catch (IOException e) {

            System.out.println("Unable to read Courses.txt");
        }

        return courseNames;
    }
}
