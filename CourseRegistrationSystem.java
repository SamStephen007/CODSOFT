import java.util.*;

class Course {
    private String course_code,title,description;
    private int capacity, registered_count = 0;
    private String[] schedule;
    private Student[] registered_students;

    public Course(String course_code, String title, String description, int capacity, String[] schedule) {
        this.course_code = course_code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        registered_students = new Student[capacity];
    }

    public String getCourseCode() { return course_code; }
    public String getTitle() { return title; }
    public int getAvailableSlots() { return capacity - registered_count; }

    public boolean registerStudent(Student student) {
        if (registered_count < capacity) {
            registered_students[registered_count++] = student;
            return true;
        }
        return false;
    }

    public boolean dropStudent(Student student) {
        for (int i = 0; i < registered_count; i++) {
            if (registered_students[i].getStudentID().equals(student.getStudentID())) {
                registered_students[i] = registered_students[--registered_count];
                return true;
            }
        }
        return false;
    }

    public void displayDetails() {
        System.out.printf("Code: %s | Title: %s | Slots: %d\n", course_code, title, getAvailableSlots());
        System.out.println("Schedule: ");
        for (String time : schedule) System.out.println(time);
    }
}

class Student {
    private String student_id, name;
    private Course[] registered_courses;
    private int registered_count = 0;

    public Student(String student_id, String name, int max_courses) {
        this.student_id = student_id;
        this.name = name;
        this.registered_courses = new Course[max_courses];
    }

    public String getStudentID() { return student_id; }

    public boolean registerForCourse(Course course) {
        if (registered_count < registered_courses.length && course.registerStudent(this)) {
            registered_courses[registered_count++] = course;
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        for (int i = 0; i < registered_count; i++) {
            if (registered_courses[i].getCourseCode().equals(course.getCourseCode())) {
                registered_courses[i] = registered_courses[--registered_count];
                return course.dropStudent(this);
            }
        }
        return false;
    }

    public void displayCourses() {
        System.out.println("Registered courses for " + name + ":");
        for (int i = 0; i < registered_count; i++) {
            System.out.println(registered_courses[i].getCourseCode() + " - " + registered_courses[i].getTitle());
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Course[] courses = {
            new Course("CS101", "Java programming", "Learn Java programming basics", 3, new String[]{"Mon 9-11", "Wed 9-11"}),
            new Course("CS102", "Data Structures", "Learn about data structures", 2, new String[]{"Tue 10-12", "Thu 10-12"}),
            new Course("CS103", "Full stack Developer", "Intro to Full stack developer", 2, new String[]{"Mon 2-4", "Wed 2-4"})
        };

        Student student = new Student("1", "Christiano Ronaldo", 3);

        System.out.println("Available courses:");
        for (Course course : courses) course.displayDetails();

        System.out.print("\nEnter course code to register: ");
        String code = scanner.nextLine();
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                if (student.registerForCourse(course)) System.out.println("Registration successful!");
                else System.out.println("Registration failed. Course may be full.");
                break;
            }
        }

        student.displayCourses();

        System.out.print("\nEnter course code to drop: ");
        code = scanner.nextLine();
        for (Course course : courses) {
            if (course.getCourseCode().equals(code)) {
                if (student.dropCourse(course)) System.out.println("Course dropped successfully.");
                else System.out.println("Failed to drop course.");
                break;
            }
        }

        student.displayCourses();
        scanner.close();
    }
}
