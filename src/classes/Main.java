package classes;

import java.util.*;

public class Main {
    public static List<Teacher> createTeachers(Scanner scanner) {
        List<Teacher> teachers = new ArrayList<>();
        System.out.print("Enter number of teachers to create: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());
            teachers.add(new Teacher(name, salary));
        }
        return teachers;
    }

    public static List<Course> createCourses(Scanner scanner) {
        List<Course> courses = new ArrayList<>();
        System.out.print("\nEnter number of courses to create: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            double price = Double.parseDouble(scanner.nextLine());
            courses.add(new Course(name, price));
        }
        return courses;
    }

    public static List<Student> createStudents(Scanner scanner) {
        List<Student> students = new ArrayList<>();
        System.out.print("\nEnter number of students to create: ");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            students.add(new Student(name, address, email));
        }
        return students;
    }
}
