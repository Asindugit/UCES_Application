package Registration;

public class Course {

    private String courseID;
    private String courseName;
    private String lecturer;
    private String duration;
    private double courseFee;
    private int seats;

    // Constructor -------------------------------------------------------------
    public Course(String courseID, String courseName, String lecturer, 
            String duration, double courseFee, int seats) {

        this.courseID = courseID;
        this.courseName = courseName;
        this.lecturer = lecturer;
        this.duration = duration;
        this.courseFee = courseFee;
        this.seats = seats;
    }

    // Getters -----------------------------------------------------------------
    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLecturer() {
        return lecturer;
    }

    public String getDuration() {
        return duration;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public int getSeats() {
        return seats;
    }

    // Setters -----------------------------------------------------------------
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    // Convert Course object to file format ------------------------------------
    @Override
    public String toString() {

        return courseID + ","
                + courseName + ","
                + lecturer + ","
                + duration + ","
                + courseFee + ","
                + seats;
    }
}