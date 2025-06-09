
import java.util.UUID;

class Course {

    private final String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;  // Variable nullable

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString(); // Generacion automatica de courseId
        this.name = name;
        this.price = price;
        this.moneyEarned = 0.0;
        this.teacher = null; // Inicialmente no hay profesor asignado
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
