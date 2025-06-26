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

        System.out.print("Enter the name of the school: ");
        String schoolName = scanner.nextLine();
        System.out.println("\n==============================");
        System.out.println("  " + schoolName.toUpperCase() + " - SCHOOL MANAGEMENT SYSTEM");
        System.out.println("==============================");
        System.out.println("Welcome! You can manage teachers, courses and students from this system.");
        System.out.println("Available commands:");
        System.out.println(" - ENROLL [STUDENT_ID] [COURSE_ID]       -> Enroll student in a course");
        System.out.println(" - ASSIGN [TEACHER_ID] [COURSE_ID]       -> Assign teacher to a course");
        System.out.println(" - SHOW COURSES                          -> List all courses");
        System.out.println(" - SHOW COURSES [TEACHER_ID]             -> List courses taught by a teacher");
        System.out.println(" - SHOW STUDENTS                         -> List all students");
        System.out.println(" - SHOW STUDENTS [COURSE_ID]             -> List students in a specific course");
        System.out.println(" - SHOW TEACHERS                         -> List all teachers");
        System.out.println(" - SHOW MONEY EARNED                     -> Show total money earned from courses");
        System.out.println(" - SHOW MONEY SPENT                      -> Show total money spent on salaries");
        System.out.println(" - SHOW STATS                            -> Display school statistics");
        System.out.println(" - SHOW PROFIT                           -> Calculate school profit");
        System.out.println(" - LOOKUP COURSE [COURSE_ID]             -> View details of a course");
        System.out.println(" - LOOKUP STUDENT [STUDENT_ID]           -> View details of a student");
        System.out.println(" - LOOKUP TEACHER [TEACHER_ID]           -> View details of a teacher");
        System.out.println(" - EXIT                                  -> Exit the system");
        System.out.println("==============================\n");

        // Teachers
        int teacherCount = readInt(scanner, "Enter number of teachers to create: ");
        for (int i = 0; i < teacherCount; i++) {
            System.out.println("Enter details for Teacher " + (i + 1) + ":");
            String name;
            do {
                System.out.print("Name: ");
                name = scanner.nextLine();
                if (!isValidName(name)) {
                    System.out.println("Invalid name. Names should not contain numbers.");
                }
            } while (!isValidName(name));

            double salary = readDouble(scanner, "Salary: ");
            teachers.add(new Teacher(name, salary));
        }

        // Courses
        int courseCount = readInt(scanner, "\nEnter number of courses to create: ");
        for (int i = 0; i < courseCount; i++) {
            System.out.println("Enter details for Course " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            double price = readDouble(scanner, "Price: ");
            courses.add(new Course(name, price));
        }

        // Students
        int studentCount = readInt(scanner, "\nEnter number of students to create: ");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter details for Student " + (i + 1) + ":");
            String name;
            do {
                System.out.print("Name: ");
                name = scanner.nextLine();
                if (!isValidName(name)) {
                    System.out.println("Invalid name. Names should not contain numbers.");
                }
            } while (!isValidName(name));

            System.out.print("Address: ");
            String address = scanner.nextLine();

            String email;
            do {
                System.out.print("Email: ");
                email = scanner.nextLine();
                if (!isValidEmail(email)) {
                    System.out.println("Invalid email format. Please enter a valid email.");
                }
            } while (!isValidEmail(email));

            students.add(new Student(name, address, email));
        }

        // Commands
        System.out.println("\nYou can now enter commands [ENROLL-ASSIGN-SHOW-LOOKUP]. Type 'EXIT' to quit.");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("EXIT"))
                break;

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
                        System.out.println("Usage: SHOW [COURSES|STUDENTS|TEACHERS|MONEY|STATS]");
                        break;
                    }
                    switch (parts[1].toUpperCase()) {
                        case "COURSES":
                            if (parts.length > 2) {
                                String teacherId = parts[2];
                                courses.stream()
                                        .filter(c -> c.getTeacher() != null &&
                                                c.getTeacher().getTeacherId().equals(teacherId))
                                        .forEach(System.out::println);
                            } else {
                                courses.forEach(System.out::println);
                            }
                            break;
                        case "STUDENTS":
                            if (parts.length > 2) {
                                String courseId = parts[2];
                                students.stream()
                                        .filter(s -> s.getCourse() != null &&
                                                s.getCourse().getCourseId().equals(courseId))
                                        .forEach(System.out::println);
                            } else {
                                students.forEach(System.out::println);
                            }
                            break;
                        case "TEACHERS":
                            teachers.forEach(System.out::println);
                            break;
                        case "MONEY":
                            if (parts.length <= 2) {
                                System.out.println("Usage: SHOW MONEY [EARNED|SPENT]");
                                break;
                            }
                            if (parts.length > 3) {
                                System.out.println("Invalid command. Too many arguments.");
                                System.out.println("Usage: SHOW MONEY [EARNED|SPENT]");
                                break;
                            }
                            switch (parts[2].toUpperCase()) {
                                case "EARNED":
                                    double totalEarned = courses.stream()
                                            .mapToDouble(Course::getMoneyEarned)
                                            .sum();
                                    System.out.printf("Total money earned: $%.2f\n", totalEarned);
                                    break;
                                case "SPENT":
                                    double totalSpent = teachers.stream()
                                            .mapToDouble(Teacher::getSalary)
                                            .sum();
                                    System.out.printf("Total money spent on salaries: $%.2f\n", totalSpent);
                                    break;
                                default:
                                    System.out.println("Invalid option. Usage: SHOW MONEY [EARNED|SPENT]");
                            }
                            break;
                        case "STATS":
                            System.out.println("\n=== School Statistics ===");
                            System.out.println("Number of Teachers: " + teachers.size());
                            System.out.println("Number of Courses: " + courses.size());
                            System.out.println("Number of Students: " + students.size());

                            double totalEarned = courses.stream()
                                    .mapToDouble(Course::getMoneyEarned)
                                    .sum();
                            double totalSalaries = teachers.stream()
                                    .mapToDouble(Teacher::getSalary)
                                    .sum();

                            System.out.printf("Total Revenue: $%.2f\n", totalEarned);
                            System.out.printf("Total Salaries: $%.2f\n", totalSalaries);
                            System.out.printf("Net Profit: $%.2f\n", totalEarned - totalSalaries);

                            long assignedCourses = courses.stream()
                                    .filter(c -> c.getTeacher() != null)
                                    .count();
                            System.out.printf("Course Assignment Rate: %.1f%%\n",
                                    (courses.size() > 0 ? (assignedCourses * 100.0 / courses.size()) : 0));
                            break;
                        case "PROFIT":
                            double totalEarnedProfit = courses.stream().mapToDouble(Course::getMoneyEarned).sum();
                            double totalSalariesProfit = teachers.stream().mapToDouble(Teacher::getSalary).sum();
                            double profit = totalEarnedProfit - totalSalariesProfit;
                            System.out.printf("Profit: $%.2f\n", profit);
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
                            Optional<Course> foundCourse = courses.stream().filter(c -> c.getCourseId().equals(id))
                                    .findFirst();
                            if (foundCourse.isPresent()) {
                                System.out.println(foundCourse.get());
                            } else {
                                System.out.println("Course not found.");
                            }
                            break;
                        case "STUDENT":
                            Optional<Student> foundStudent = students.stream().filter(s -> s.getStudentId().equals(id))
                                    .findFirst();
                            if (foundStudent.isPresent()) {
                                System.out.println(foundStudent.get());
                            } else {
                                System.out.println("Student not found.");
                            }
                            break;
                        case "TEACHER":
                            Optional<Teacher> foundTeacher = teachers.stream().filter(t -> t.getTeacherId().equals(id))
                                    .findFirst();
                            if (foundTeacher.isPresent()) {
                                System.out.println(foundTeacher.get());
                            } else {
                                System.out.println("Teacher not found.");
                            }
                            break;
                        default:
                            System.out.println("Unknown LOOKUP type.");
                    }
                    break;
                default:
                    System.out.println("Unknown command.");
            }
        }
        System.out.println("Exiting system. Goodbye!");
        scanner.close();
    }

    private static boolean isValidName(String name) {
        return !name.matches(".*\\d.*");
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }

    private static int readInt(Scanner scanner, String message) {
        int number = -1;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                number = Integer.parseInt(input);
                if (number >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a numeric value.");
            }
        }
        return number;
    }

    private static double readDouble(Scanner scanner, String message) {
        double number = -1;
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            try {
                number = Double.parseDouble(input);
                if (number >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a numeric value.");
            }
        }
        return number;
    }
}