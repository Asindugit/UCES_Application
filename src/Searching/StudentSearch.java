package Searching;

import Registration.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StudentSearch {

    // Read Student.txt file ---------------------------------------------------
    public ArrayList<Student> readStudents() {

        ArrayList<Student> studentList = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader("Students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String data[] = line.split(",");
                Student student = new Student(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4],
                        data[5],
                        data[6]
                );
                studentList.add(student);
            }
            reader.close();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());

        }

        return studentList;

    }

    // Binary Search by Student ID ---------------------------------------------
    public Student binarySearch(String searchID) {
        
        ArrayList<Student> students = readStudents();
        
        int first = 0;
        int last = students.size() - 1;

        while (first <= last) {

            int middle = (first + last) / 2;
            Student student = students.get(middle);
            int result = student.getStudentID() .compareToIgnoreCase(searchID);

            if (result == 0) {
                

                return student;
            } 
            else if (result < 0) {
                first = middle + 1;
            } 
            else {
                last = middle - 1;
            }
        }

        return null;
    }
}
