import classes.Course;
import classes.Student;
import classes.Teacher;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Teacher> teachers = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        // Teachers
        System.out.print("Enter number of teachers to create: ");
        int teacherCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < teacherCount; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            teachers.add(new Teacher(name, salary));
        }

        // Courses
        System.out.print("\nEnter number of courses to create: ");
        int courseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            courses.add(new Course(name, price));
        }

        // Students
        System.out.print("\nEnter number of students to create: ");
        int studentCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            students.add(new Student(name, address, email));
        }
    }
}