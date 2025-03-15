import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity;
    List<Student> registeredStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }

    public boolean dropStudent(Student student) {
        return registeredStudents.remove(student);
    }

    public int availableSlots() {
        return capacity - registeredStudents.size();
    }

    public void displayInfo() {
        System.out.println(code + ": " + title + " (" + availableSlots() + " slots left)");
        System.out.println("Schedule: " + schedule);
        System.out.println("Description: " + description);
        System.out.println();
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void registerCourse(Course course) {
        if (course.registerStudent(this)) {
            registeredCourses.add(course);
            System.out.println(name + " registered for " + course.title);
        } else {
            System.out.println("Course is full!");
        }
    }

    public void dropCourse(Course course) {
        if (course.dropStudent(this)) {
            registeredCourses.remove(course);
            System.out.println(name + " dropped " + course.title);
        } else {
            System.out.println("You are not registered in this course!");
        }
    }
}

public class task5 {
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Course course1 = new Course("CS101", "java Programming", "Basic programming concepts", 3, "Mon-Wed 10 AM");
        Course course2 = new Course("CS102", "Data Structures", "Introduction to data structures", 2, "Tue-Thu 2 PM");
        courses.add(course1);
        courses.add(course2);
        
        Student student1 = new Student("LE508", "Ravi");
        Student student2 = new Student("LE509", "Rahul");
        students.add(student1);
        students.add(student2);
        
        while (true) {
            System.out.println("1. View Courses\n2. Register Course\n3. Drop Course\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    for (Course c : courses) {
                        c.displayInfo();
                    }
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = findStudent(studentId);
                    if (student != null) {
                        System.out.print("Enter course code: ");
                        String courseCode = scanner.nextLine();
                        Course course = findCourse(courseCode);
                        if (course != null) {
                            student.registerCourse(course);
                        } else {
                            System.out.println("Course not found!");
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentId = scanner.nextLine();
                    student = findStudent(studentId);
                    if (student != null) {
                        System.out.print("Enter course code: ");
                        String courseCode = scanner.nextLine();
                        Course course = findCourse(courseCode);
                        if (course != null) {
                            student.dropCourse(course);
                        } else {
                            System.out.println("Course not found!");
                        }
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static Student findStudent(String id) {
        for (Student s : students) {
            if (s.id.equals(id)) return s;
        }
        return null;
    }

    public static Course findCourse(String code) {
        for (Course c : courses) {
            if (c.code.equals(code)) return c;
        }
        return null;
    }
}
