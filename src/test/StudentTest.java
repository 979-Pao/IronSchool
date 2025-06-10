package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import classes.Course;
import classes.Student;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    private Student student;
    private Course course;

    @BeforeEach
    public void setUp() {
        student = new Student("Juan Pérez", "Calle Falsa 123", "juan@example.com");
        course = new Course("Matemáticas", 100.0); // Creamos un curso de ejemplo
    }

    @Test
    public void testStudentCreation() {
        assertNotNull(student.getStudentId()); // Verificar que el ID no es nulo
        assertEquals("Juan Pérez", student.getName());
        assertEquals("Calle Falsa 123", student.getAddress());
        assertEquals("juan@example.com", student.getEmail());
    }

    @Test
    public void testEnrollInCourse() {
        student.enroll(course);

        assertEquals(course, student.getCourse()); // El curso debe ser el que se inscribió
        assertEquals(100.0, course.getMoneyEarned(), 0.01); // El dinero ganado por el curso debe actualizarse
    }

    @Test
    public void testEnrollInCourseWhenAlreadyEnrolled() {
        student.enroll(course); // Inscribir al estudiante en el primer curso
        Course newCourse = new Course("Historia", 50.0);
        student.enroll(newCourse); // Inscribir al estudiante en un nuevo curso

        assertEquals(newCourse, student.getCourse()); // El curso debe ser el nuevo
        assertEquals(50.0, newCourse.getMoneyEarned(), 0.01); // El nuevo curso debe tener el dinero ganado
    }
}
