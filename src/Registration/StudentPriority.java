package Registration;

import java.util.Comparator;

public class StudentPriority implements Comparator<Student> {


    @Override
    public int compare(Student s1, Student s2) {

        int year1 = priority(s1.getAcademicYear());

        int year2 = priority(s2.getAcademicYear());

        // Higher academic year first ------------------------------------------
        if(year1 != year2) {

            return year2 - year1;
        }

        // Same year -> registration order -------------------------------------
        return s1.getOrder() - s2.getOrder();
    }

    private int priority(String year) {

        switch(year) {

            case "Fourth Year":
                return 4;

            case "Third Year":
                return 3;

            case "Second Year":
                return 2;

            case "First Year":
                return 1;

            default:
                return 0;
        }

    }

}