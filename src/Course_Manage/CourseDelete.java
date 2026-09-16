package Course_Manage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CourseDelete {

    private static final String FileName = "Courses.txt";

    public static boolean deleteCourse(String courseID) {

        List<String> remainingCourses = new ArrayList<>();

        boolean deleted = false;

        // Read Courses.txt ----------------------------------------------------
        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                // Course ID is index 0 ----------------------------------------
                if (data.length > 0 && data[0].trim().equalsIgnoreCase(courseID)) {

                    // Do not add this course ----------------------------------
                    deleted = true;

                } else {

                    // Keep other courses --------------------------------------
                    remainingCourses.add(line);
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading Courses.txt: " + e.getMessage());

            return false;
        }

        // If course was found, rewrite file -----------------------------------
        if (deleted) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {

                for (String course : remainingCourses) {

                    writer.write(course);
                    writer.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error updating Courses.txt: " + e.getMessage());
                return false;
            }
        }

        return deleted;
    }
}
