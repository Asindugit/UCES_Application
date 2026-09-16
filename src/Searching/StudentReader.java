package Searching;


import Registration.Student;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


public class StudentReader {

    public static ArrayList<Student> readStudents() {

        ArrayList<Student> students = new ArrayList<>();

        try {
            File file = new File("Students.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while((line = reader.readLine()) != null) {

                String data[] = line.split(",");
                Student s = new Student(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        data[3],
                        data[4],
                        data[5],
                        data[6]

                );
                students.add(s);
            }
            reader.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return students;
    }
}
