package Registration;

import Course_Manage.CourseReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class CoursePriorityQueue {

    private PriorityQueue<Course> courseQueue;

    // Constructor -------------------------------------------------------------
    public CoursePriorityQueue() {

        courseQueue = new PriorityQueue<>((c1, c2)
                -> c1.getCourseID().compareTo(c2.getCourseID())
        );
    }

    // Add course to PriorityQueue ---------------------------------------------
    public void addCourse(Course course) {

        courseQueue.offer(course);
    }

    // Save new course to Courses.txt ------------------------------------------
    public boolean saveCourse(Course course) {

        try (PrintWriter pw = new PrintWriter(new FileWriter("Courses.txt", true))) {
            pw.println(course.toString());
            return true;

        } catch (IOException e) {

            System.out.println("Error writing Courses.txt: " + e.getMessage());

            return false;
        }
    }

    // Register a new course ---------------------------------------------------
    public boolean registerCourse(Course course) {
        addCourse(course);
        return saveCourse(course);
    }

    // Update existing course --------------------------------------------------
    public boolean updateCourse(Course updatedCourse) {

        try {

            // Create a new PriorityQueue --------------------------------------
            PriorityQueue<Course> updatedQueue
                    = new PriorityQueue<>((c1, c2)
                            -> c1.getCourseID().compareTo(c2.getCourseID())
                    );

            // Read existing courses -------------------------------------------
            updatedQueue.addAll(
                    CourseReader.readCourses()
            );

            // Remove old course -----------------------------------------------
            updatedQueue.removeIf(course
                    -> course.getCourseID().equalsIgnoreCase(
                            updatedCourse.getCourseID()));

            // Add updated course ----------------------------------------------
            updatedQueue.offer(updatedCourse);

            // Rewrite Courses.txt ---------------------------------------------
            try (PrintWriter writer = new PrintWriter(new FileWriter("Courses.txt"))) {

                while (!updatedQueue.isEmpty()) {

                    Course course = updatedQueue.poll();
                    writer.println(course.toString());
                }
            }

            return true;

        } catch (IOException e) {

            System.out.println("Error updating course: " + e.getMessage());

            return false;
        }
    }

    // Get PriorityQueue -------------------------------------------------------
    public PriorityQueue<Course> getCourseQueue() {

        return courseQueue;
    }
}
