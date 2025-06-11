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

        // Commands
        System.out.println("\nYou can now enter commands [ENROLL-ASSIGN-SHOW-LOOKUP]. Type 'EXIT' to quit.");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("EXIT")) break;

            String[] parts = input.split(" ");
            String command = parts[0].toUpperCase();

            switch (command) {
                case "ENROLL":
                    if (parts.length < 3) {
                        System.out.println("Usage: ENROLL [STUDENT_ID] [COURSE_ID]");
                        break;
                    }
                    Student student = students.stream()
                            .filter(s -> s.getStudentId().equals(parts[1]))
                            .findFirst().orElse(null);
                    Course course = courses.stream()
                            .filter(c -> c.getCourseId().equals(parts[2]))
                            .findFirst().orElse(null);
                    if (student != null && course != null) {
                        student.enroll(course);
                        System.out.println("Student enrolled successfully.");
                    } else {
                        System.out.println("Student or Course not found.");
                    }
                    break;

                case "ASSIGN":
                    if (parts.length < 3) {
                        System.out.println("Usage: ASSIGN [TEACHER_ID] [COURSE_ID]");
                        break;
                    }
                    Teacher teacher = teachers.stream()
                            .filter(t -> t.getTeacherId().equals(parts[1]))
                            .findFirst().orElse(null);
                    course = courses.stream()
                            .filter(c -> c.getCourseId().equals(parts[2]))
                            .findFirst().orElse(null);
                    if (teacher != null && course != null) {
                        course.setTeacher(teacher);
                        System.out.println("Teacher assigned successfully.");
                    } else {
                        System.out.println("Teacher or Course not found.");
                    }
                    break;

                case "SHOW":
                    if (parts.length < 2) {
                        System.out.println("Usage: SHOW [COURSES|STUDENTS|TEACHERS]");
                        break;
                    }
                    switch (parts[1].toUpperCase()) {
                        case "COURSES":
                            courses.forEach(System.out::println);
                            break;
                        case "STUDENTS":
                            students.forEach(System.out::println);
                            break;
                        case "TEACHERS":
                            teachers.forEach(System.out::println);
                            break;
                        default:
                            System.out.println("Unknown SHOW target.");
                    }
                    break;

                case "LOOKUP":
                    if (parts.length < 3) {
                        System.out.println("Usage: LOOKUP [COURSE|STUDENT|TEACHER] [ID]");
                        break;
                    }
                    String type = parts[1].toUpperCase();
                    String id = parts[2];
                    switch (type) {
                        case "COURSE":
                            courses.stream().filter(c -> c.getCourseId().equals(id)).findFirst()
                                    .ifPresentOrElse(System.out::println,
                                            () -> System.out.println("Course not found."));
                            break;
                        case "STUDENT":
                            students.stream().filter(s -> s.getStudentId().equals(id)).findFirst()
                                    .ifPresentOrElse(System.out::println,
                                            () -> System.out.println("Student not found."));
                            break;
                        case "TEACHER":
                            teachers.stream().filter(t -> t.getTeacherId().equals(id)).findFirst()
                                    .ifPresentOrElse(System.out::println,
                                            () -> System.out.println("Teacher not found."));
                            break;
                        default:
                            System.out.println("Unknown LOOKUP type.");
                    }
                    break;

            }
        }
    }
}