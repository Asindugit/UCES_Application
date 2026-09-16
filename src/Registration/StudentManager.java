package Registration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class StudentManager {

    // Linked List to store Student objects ------------------------------------
    private LinkedList<Student> studentList;
    private final String FileName = "Students.txt";

    // Constructor -------------------------------------------------------------
    public StudentManager() {
        studentList = new LinkedList<>();
        loadStudents();
    }

    // Register Student --------------------------------------------------------
    public boolean addStudent(Student student) {

        // Check duplicate Student ID
        for (Student existingStudent : studentList) {
            if (existingStudent.getStudentID().equals(student.getStudentID())) {
                JOptionPane.showMessageDialog(null, "Student ID already exists!",
                        "Duplicate Student", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }

        // Add Student object to LinkedList ------------------------------------
        studentList.add(student);

        // Save data to file ---------------------------------------------------
        saveToFile(student);

        JOptionPane.showMessageDialog(null, "Student Registered Successfully!",
                "Success", JOptionPane.INFORMATION_MESSAGE);

        return true;
    }

    // Data save into Students.txt ---------------------------------------------
    private void saveToFile(Student student) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName, true))) {

            writer.write(student.getStudentDetails());
            writer.newLine();

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Unable to save student details!",
                    "File Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Load existing students --------------------------------------------------
    private void loadStudents() {

        File file = new File(FileName);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {

                    Student student = new Student(
                            data[0],
                            data[1],
                            Integer.parseInt(data[2]),
                            data[3],
                            data[4],
                            data[5],
                            data[6]
                    );

                    // Add Student to LinkedList -------------------------------
                    studentList.add(student);
                }
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Unable to load student records!",
                    "File Error", JOptionPane.ERROR_MESSAGE);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(null, "Invalid student age in file!",
                    "Data Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Check whether Student ID already exists -------------------------------
    public boolean StudentIDExists(String studentID) {

        for (Student student : studentList) {
            if (student.getStudentID().trim().equals(studentID.trim())) {
                return true;
            }
        }

        return false;
    }

    // Update Student ----------------------------------------------------------
    public boolean updateStudent(Student updatedStudent) {

        String studentID = updatedStudent.getStudentID();

        // Search Student in LinkedList ----------------------------------------
        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            if (student.getStudentID().equals(studentID)) {

                // Replace old Student with updated Student --------------------
                studentList.set(i, updatedStudent);

                // Rewrite Students.txt
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {

                    for (Student s : studentList) {

                        writer.write(s.getStudentDetails());
                        writer.newLine();
                    }

                    return true;

                } catch (IOException e) {

                    JOptionPane.showMessageDialog(null, "Unable to update Students.txt!",
                            "File Error", JOptionPane.ERROR_MESSAGE);

                    return false;
                }
            }
        }

        return false;
    }

    // Get all students --------------------------------------------------------
    public List<Student> getAllStudents() {

        return studentList;
    }
}
