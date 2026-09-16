package Student_Manage;

import Registration.Student;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class StudentBinarySearch {

    // Binary Search by Student ID ---------------------------------------------
    public static Student searchByStudentID(List<Student> students, String searchID) {

        // Sort by Student ID --------------------------------------------------
        students.sort(Comparator.comparing(Student::getStudentID));

        int first = 0;
        int last = students.size() - 1;

        while (first <= last) {
            int middle = (first + last) / 2;
            Student student = students.get(middle);
            int result = student.getStudentID().compareToIgnoreCase(searchID);

            if (result == 0) {
                return student;
            }

            if (result < 0) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
        }

        return null;
    }

    // Delete student from Students.txt ----------------------------------------
    public static boolean deleteStudent(String studentID) {

        String fileName = "Students.txt";

        List<String> remainingStudents = new ArrayList<>();
        boolean deleted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split(",");

                // Student ID is index 0 ---------------------------------------
                if (data.length > 0 && data[0].trim().equalsIgnoreCase(studentID)) {

                    // Do not add this student ---------------------------------
                    deleted = true;

                } else {

                    // Keep other students -------------------------------------
                    remainingStudents.add(line);
                }
            }

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null, "Error reading Students.txt: "
                    + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            return false;
        }

        // Rewrite file --------------------------------------------------------
        if (deleted) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

                for (String student : remainingStudents) {

                    writer.write(student);
                    writer.newLine();
                }

            } catch (IOException e) {

                JOptionPane.showMessageDialog(null, "Error updating Students.txt: "
                        + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

                return false;
            }
        }

        return deleted;
    }
}
