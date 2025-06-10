package test;

import model.Course;
import model.Student;
import model.Teacher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    private Course course;
    private Teacher teacher;

    @BeforeEach
    void setUp() {
        course = new Course("Modulo 2", 999.99);
        teacher = new Teacher("Jarko", 5000.0);
    }

    @Test
    void testCourseCreation() {
        assertNotNull(course.getCourseId());
        assertEquals("Modulo 2", course.getName());
        assertEquals(999.99, course.getPrice());
        assertEquals(0.0, course.getMoneyEarned());
        assertNull(course.getTeacher());
    }

    @Test
    void testSetNameAndPrice() {
        course.setName("Programacion con Java");
        course.setPrice(899.99);

        assertEquals("Programacion con Java", course.getName());
        assertEquals(899.99, course.getPrice());
    }

    @Test
    void testAssignTeacher() {
        course.setTeacher(teacher);

        assertNotNull(course.getTeacher());
        assertEquals("Jarko", course.getTeacher().getName());
    }

    @Test
    void testAddMoneyEarned() {
        course.addMoneyEarned(999.99);
        assertEquals(999.99, course.getMoneyEarned());

        // Test añadiendo mas dinero
        course.addMoneyEarned(500.0);
        assertEquals(1499.99, course.getMoneyEarned());

        // Test añadiendo dinero negativo (no deberia modificar el total)
        course.addMoneyEarned(-100.0);
        assertEquals(1499.99, course.getMoneyEarned());
    }

    @Test
    void testToString() {
        String expectedString = "Course ID: " + course.getCourseId()
                + ", Name: Modulo 2"
                + ", Price: $999.99"
                + ", Money Earned: $0.0"
                + ", Teacher: Not Assigned";
        assertEquals(expectedString, course.toString());

        // Test con profesor asignado
        course.setTeacher(teacher);
        expectedString = "Course ID: " + course.getCourseId()
                + ", Name: Modulo 2"
                + ", Price: $999.99"
                + ", Money Earned: $0.0"
                + ", Teacher: Jarko";
        assertEquals(expectedString, course.toString());
    }
}
