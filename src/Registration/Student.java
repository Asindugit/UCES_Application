package Registration;

// Child Class -----------------------------------------------------------------
public class Student extends Person {

    private int studentAge;
    private String course;
    private String academicYear;
    private String date;
    private String time;

    // Only use in PriorityQueue -----------------------------------------------
    private int order;

    // Constructor -------------------------------------------------------------
    public Student(String studentID, String studentName, int studentAge,
            String course, String academicYear, String date, String time) {

        super(studentID, studentName);

        this.studentAge = studentAge;
        this.course = course;
        this.academicYear = academicYear;
        this.date = date;
        this.time = time;
    }

    // Constructor used by PriorityQueue ---------------------------------------
    public Student(String studentID, String studentName, int studentAge,
            String course, String academicYear,
            String date, String time, int order) {

        super(studentID, studentName);

        this.studentAge = studentAge;
        this.course = course;
        this.academicYear = academicYear;
        this.date = date;
        this.time = time;
        this.order = order;
    }

    // Getters ---------------------------------------------------------
    public String getStudentID() {
        return getId();
    }

    public String getStudentName() {
        return getName();
    }

    public int getStudentAge() {
        return studentAge;
    }

    public String getCourse() {
        return course;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getOrder() {
        return order;
    }

    // Setters -----------------------------------------------------------------
    public void setStudentID(String studentID) {
        setId(studentID);
    }

    public void setStudentName(String studentName) {
        setName(studentName);
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    // Write format ------------------------------------------------------------
    public String getStudentDetails() {

        return getStudentID() + ","
                + getStudentName() + ","
                + getStudentAge() + ","
                + getCourse() + ","
                + getAcademicYear() + ","
                + getDate() + ","
                + getTime();
    }

    @Override
    public String toString() {

        return getStudentName() + " - "
                + getAcademicYear() + " - "
                + getDate();
    }
}
