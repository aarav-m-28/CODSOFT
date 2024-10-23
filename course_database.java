package CODSOFT;

import java.util.ArrayList;
import java.util.Scanner;

public class course_database {
    
    String id;
    String password;
    String name;
    ArrayList<course_database> users = new ArrayList<>();
    
    ArrayList<String> registeredCourses = new ArrayList<>();
    static ArrayList<String> availableCourseCodes = new ArrayList<>();
    static ArrayList<String> availableCourseNames = new ArrayList<>();

    
    public course_database(String id, String password, String name) {
        this.id = id.toUpperCase();
        this.password = password.toUpperCase();
        this.name = name;
    }

    void Menu(Scanner scanner) {
        int choice;
        do {
            System.out.printf("\n\nUser ID: %s\nNAME: %s\n", id, name);
            System.out.println("1. View registered courses.");
            System.out.println("2. Register for a course.");
            System.out.println("3. Drop a course.");
            System.out.println("4. Exit!");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    view_courses();
                    break;
                case 2:
                    register_course(scanner);
                    break;
                case 3:
                    dropCourse(scanner);
                    break;
                case 4:
                    System.out.println("Exiting menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    static {
        availableCourseCodes.add("CS101");
        availableCourseNames.add("Basics of Java");
        availableCourseCodes.add("MATH102");
        availableCourseNames.add("Calculus I");
        availableCourseCodes.add("PHY103");
        availableCourseNames.add("Physics I");
        availableCourseCodes.add("ENG104");
        availableCourseNames.add("English Literature");
        availableCourseCodes.add("HIST105");
        availableCourseNames.add("World History");
        availableCourseCodes.add("BIO106");
        availableCourseNames.add("Biology I");
        availableCourseCodes.add("CHE107");
        availableCourseNames.add("Chemistry I");
        availableCourseCodes.add("PSY108");
        availableCourseNames.add("Introduction to Psychology");
        availableCourseCodes.add("ECON109");
        availableCourseNames.add("Microeconomics");
        availableCourseCodes.add("SOC110");
        availableCourseNames.add("Sociology I");
    }

    void view_courses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("NO REGISTERED COURSES.");
        } else {
            System.out.println("Registered courses:");
            for (String courseCode : registeredCourses) {
                int n = availableCourseCodes.indexOf(courseCode);
                System.out.printf("%s: %s\n", courseCode, availableCourseNames.get(n));
            }
        }
    }

    void available_courses() {
        System.out.println("AVAILABLE COURSES FOR YOU TO REGISTER ARE:");
        boolean available = false;
        for (int i = 0; i < availableCourseCodes.size(); i++) {
            if (!registeredCourses.contains(availableCourseCodes.get(i))) {
                System.out.printf("%s: %s\n", availableCourseCodes.get(i), availableCourseNames.get(i));
                available = true;
            }
        }
        if (!available) {
            System.out.println("No courses available for registration.");
        }
    }

    void register_course(Scanner scanner) {
        available_courses();
        System.out.println("ENTER COURSE CODE TO REGISTER:");
        String coursecode = scanner.next().toUpperCase();
        if (availableCourseCodes.contains(coursecode)) {
            if (registeredCourses.contains(coursecode)) {
                System.out.println("YOU HAVE ALREADY REGISTERED FOR THIS COURSE!");
            } else {
                registeredCourses.add(coursecode);
                int n = availableCourseCodes.indexOf(coursecode);
                System.out.println("YOU HAVE SUCCESSFULLY REGISTERED FOR " + availableCourseNames.get(n));
            }
        } else {
            System.out.println("INVALID COURSE CODE");
        }
    }

    void dropCourse(Scanner scanner) {
        if (registeredCourses.isEmpty()) {
            System.out.println("No courses to drop.");
        } else {
            System.out.println("Registered courses:");
            for (String courseCode : registeredCourses) {
                int index = availableCourseCodes.indexOf(courseCode);
                System.out.printf("%s: %s\n", courseCode, availableCourseNames.get(index));
            }

            System.out.print("Enter course code to drop: ");
            String courseCode = scanner.next().toUpperCase();
            if (registeredCourses.remove(courseCode)) {
                int index = availableCourseCodes.indexOf(courseCode);
                System.out.println("Course " + availableCourseNames.get(index) + " dropped successfully.");
            } else {
                System.out.println("You are not registered for this course.");
            }
        }
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<course_database> users = new ArrayList<>();
        System.out.printf("ONLY 2 USERS AVAILABLE->\nID:ag1810\nPWD:1234\nID:User02\nPWD:0987\n");
        course_database Aarav = new course_database("AG1810", "1234", "Aarav Mohan Gupta");
        course_database User02 = new course_database("UR1234", "0987", "USER02");
        Aarav.registeredCourses.add("MATH102");
        Aarav.registeredCourses.add("CS101");
        User02.registeredCourses.add("PHY103");
        User02.registeredCourses.add("ENG104");

        users.add(Aarav);
        users.add(User02);

        do {
            System.out.printf("Enter user ID: ");
            String inputId = scanner.next().toUpperCase();

            System.out.print("Enter password: ");
            String inputPwd = scanner.next().toUpperCase();

            for (course_database user : users) {
                if (user.id.equals(inputId) && user.password.equals(inputPwd)) {
                    user.Menu(scanner);
                    break;
                } else if (!user.id.equals(inputId) && !user.password.equals(inputPwd)) {
                    System.out.println("invalid credentials");
                    n = 1;
                    break;
                }
            }
        } while (n == 1);
        scanner.close();
    }
}
