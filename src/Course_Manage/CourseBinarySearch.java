package Course_Manage;

import Registration.Course;

import java.util.Comparator;
import java.util.List;

public class CourseBinarySearch {

    // Search Course by Course ID ----------------------------------------------
    public static Course searchByCourseID(
            List<Course> courses, String searchID) {

        // Sort courses by Course ID -------------------------------------------
        courses.sort(Comparator.comparing(Course::getCourseID));

        int first = 0;
        int last = courses.size() - 1;

        // Binary Search -------------------------------------------------------
        while (first <= last) {

            int middle = (first + last) / 2;
            Course course = courses.get(middle);
            int result = course.getCourseID().compareToIgnoreCase(searchID);

            // Course found ----------------------------------------------------
            if (result == 0) {
                return course;
            }

            // Search right side -----------------------------------------------
            if (result < 0) {
                first = middle + 1;
            } // Search left side ------------------------------------------------
            else {
                last = middle - 1;
            }
        }

        // Course not found ----------------------------------------------------
        return null;
    }
}
