package Course_Manage;

import Registration.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CourseReader {

    private static final String FileName = "Courses.txt";

    // Read all courses from Courses.txt ---------------------------------------
    public static List<Course> readCourses() {

        List<Course> courses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                // Skip empty lines --------------------------------------------
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                if (data.length >= 6) {

                    try {

                        String courseID = data[0].trim();

                        String courseName = data[1].trim();

                        String lecturer = data[2].trim();

                        String duration = data[3].trim();

                        double courseFee = Double.parseDouble(data[4].trim());

                        int seats = Integer.parseInt(data[5].trim());

                        Course course = new Course(courseID, courseName, lecturer,
                                duration, courseFee, seats);

                        courses.add(course);

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Invalid course data: " + line,
                                "Invalid Course Data", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading Courses.txt: " + e.getMessage());
        }

        return courses;
    }
}
