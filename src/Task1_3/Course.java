package Task1_3;

import java.util.ArrayList;
import java.util.List;

public class Course {
    String id;
    String title;
    String type;
    List<Student> students;
    String lecturer;

    public Course(String id, String title, String type, String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.lecturer = lecturer;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public boolean contains(Student student) {
        return students.contains(student);
    }

    public int countStudentsByYear(int year) {
        int count = 0;
        for (Student student : students) {
            if (student.year == year) {
                count++;
            }
        }
        return count;
    }
}
