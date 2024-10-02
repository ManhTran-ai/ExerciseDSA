package Task1_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Faculty {
    String name;
    String address;
    List<Course> courses;

    public Faculty(String name, String address) {
        this.name = name;
        this.address = address;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {

        this.courses.add(course);
    }

    public int countStudentsByYear(int year) {
        List<Student> countStudents = new ArrayList<>(); //
        int totalStudent = 0;

        for (Course course : courses){
            for (Student student : course.students){
                if (student.year == year && !countStudents.contains(student)){
                    countStudents.add(student); //
                    totalStudent++;
                }
            }
        }
        return totalStudent;
    }

    public Course getCourseWithMaxStudents() {
        Course maxCourse = null;
        int maxStudents = 0;
        for (Course course : courses) {
            if (course.students.size() > maxStudents) {
                maxStudents = course.students.size();
                maxCourse = course;
            }
        }
        return maxCourse;
    }

    public List<Course> getCoursesByLecturer(String lecturer) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.lecturer.equals(lecturer)) {
                result.add(course);
            }
        }
        return result;
    }
}

