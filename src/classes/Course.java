package classes;

import java.util.UUID;

public class Course {

    private static int idCounter = 1;

    private final String uuid;      // UUID para uso interno
    private final String courseId;  // ID legible tipo C001
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.uuid = UUID.randomUUID().toString();                // Uso interno
        this.courseId = String.format("C%03d", idCounter++);     // ID visible
        this.name = name;
        this.price = price;
        this.moneyEarned = 0.0;
        this.teacher = null;
    }

    // Funciones Getters
    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    //  Funciones Setters
    //  Permiten modificar los atributos del curso como el nombre, precio y profesor asignado
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    // Metodo para agregar dinero ganado por el curso
    // Solo acepta valor positivo
    public void addMoneyEarned(double amount) {
        if (amount > 0) {
            this.moneyEarned += amount;
        }
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId
                + ", Name: " + name
                + ", Price: $" + price
                + ", Money Earned: $" + moneyEarned
                + ", Teacher: " + (teacher != null ? teacher.getName() : "Not Assigned");
    }
}
