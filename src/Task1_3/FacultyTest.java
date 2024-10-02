package Task1_3;

import junit.framework.TestCase;

import java.util.List;

public class FacultyTest extends TestCase {
    public void testAddStudentToCourse() {
        Student student = new Student("S01","Nguyen Van A", 2023);

        Course course = new Course("214441"," Cau Truc Du Lieu", "Ly thuyet", " Nguyen Van Du");
        course.addStudent(student);

        assertTrue(course.contains(student));
    }

    public void testCountStudentsByYear() {
        Student student1 = new Student("S01","Nguyen Van A", 2023);
        Student student2 = new Student("S02","Nguyen Van B", 2022);

        Course course = new Course("C01"," Cau Truc Du Lieu","Ly Thuyet","Nguyen Van Du");
        course.addStudent(student1);
        course.addStudent(student2);

        assertEquals(1,course.countStudentsByYear(2023));
    }
    public void testCountStudentInFacultyByYear(){
        Faculty faculty = new Faculty("Cong Nghe Thong Tin","Dai Hoc Nong Lam");

        Course course1 = new Course("C01"," Cau Truc Du Lieu","Ly Thuyet","Nguyen Van Du");
        Course course2 = new Course("C02"," Toan Roi Rac","Ly Thuyet","Nguyen Thi Phuong Tram");

        faculty.addCourse(course1);
        faculty.addCourse(course2);

        assertEquals(0,faculty.countStudentsByYear(2023));
        assertEquals(0,faculty.countStudentsByYear(2022));

    }

    public void testGetCourseWithMostStudents() {
        Faculty faculty = new Faculty("Cong Nghe Thong Tin","Dai Hoc Nong Lam");

        Course course1 = new Course("C01"," Cau Truc Du Lieu","Ly Thuyet","Nguyen Van Du");
        Course course2 = new Course("C02"," Toan Roi Rac","Ly Thuyet","Nguyen Thi Phuong Tram");

        Student student1 = new Student("S01","Nguyen Van A", 2023);
        Student student2 = new Student("S02","Nguyen Van B", 2022);

        course1.addStudent(student1);
        course1.addStudent(student2);
        course2.addStudent(new Student("S03","Nguyen Van C", 2023));

        faculty.addCourse(course1);
        faculty.addCourse(course2);

        assertEquals(course1, faculty.getCourseWithMaxStudents());
    }

    public void testGetCoursesByLecturer() {
        Faculty faculty = new Faculty("Cong Nghe Thong Tin","Dai Hoc Nong Lam");

        Course course1 = new Course("C01"," Cau Truc Du Lieu","Ly Thuyet","Nguyen Van Du");
        Course course2 = new Course("C02"," Toan Roi Rac","Ly Thuyet","Nguyen Thi Phuong Tram");

        faculty.addCourse(course1);
        faculty.addCourse(course2);

        List<Course> DuCourses = faculty.getCoursesByLecturer("Nguyen Van Du");
        assertEquals(1, DuCourses.size());
        assertEquals(course1, DuCourses.get(0));
    }

}