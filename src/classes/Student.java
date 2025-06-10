package classes;

import java.util.UUID;

public class Student {
    private final String studentId;
    private String name;
    private String address;
    private String email;
    private Course course; // Nullable

    // Constructor
    public Student(String name, String address, String email) {
        this.studentId = UUID.randomUUID().toString(); // Generación automática de studentId
        this.name = name;
        this.address = address;
        this.email = email;
        this.course = null; // Inicialmente no está inscrito en ningún curso
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Método para inscribir a un estudiante en un curso
    public void enroll(Course course) {
        this.course = course;
        // Actualizamos el dinero ganado por el curso
        if (course != null) {
            course.addMoneyEarned(course.getPrice());
        }
    }
}