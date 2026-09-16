package Registration;

public class StudentCourse {

    private String registrationID;
    private String course;
    private String studentID;
    private String studentName;
    private String registrationDate;
    private String registrationTime;

    public StudentCourse(String registrationID, String course, String studentID,
                         String studentName, String registrationDate,
                         String registrationTime) {

        this.registrationID = registrationID;
        this.course = course;
        this.studentID = studentID;
        this.studentName = studentName;
        this.registrationDate = registrationDate;
        this.registrationTime = registrationTime;
    }

    // Getters -------------------------------------------------------------

    public String getRegistrationID() {
        return registrationID;
    }

    public String getCourse() {
        return course;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getRegistrationTime() {
        return registrationTime;
    }
}