import java.util.*;

class Course {
    private final String code;
    private final String title;
    private final int capacity;
    private final Set<String> enrolledStudents = new HashSet<>();
    private final List<String> prerequisites = new ArrayList<>();
    private final LinkedList<String> waitlist = new LinkedList<>();

    Course(String code, String title, int capacity) {
        this.code = code;
        this.title = title;
        this.capacity = capacity;
    }

    String getCode() { return code; }
    String getTitle() { return title; }
    int getCapacity() { return capacity; }
    Set<String> getEnrolledStudents() { return enrolledStudents; }
    List<String> getPrerequisites() { return prerequisites; }
    LinkedList<String> getWaitlist() { return waitlist; }

    void addPrerequisite(String courseCode) {
        if (!prerequisites.contains(courseCode)) {
            prerequisites.add(courseCode);
        }
    }

    boolean isFull() { return enrolledStudents.size() >= capacity; }

    @Override
    public String toString() {
        return String.format("%s - %s | Seats: %d/%d | Prereqs: %s | Enrolled: %s | Waitlist: %s",
                code, title, enrolledStudents.size(), capacity, prerequisites, enrolledStudents, waitlist);
    }
}

public class CourseRegistrationPortal {
    private final Map<String, Course> courses = new HashMap<>();
    private final Map<String, Set<String>> completedCourses = new HashMap<>();

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public void markCompleted(String studentId, String courseCode) {
        completedCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(courseCode);
    }

    private List<String> missingPrerequisites(String studentId, Course course) {
        Set<String> done = completedCourses.getOrDefault(studentId, Collections.emptySet());
        List<String> missing = new ArrayList<>();
        for (String prereq : course.getPrerequisites()) {
            if (!done.contains(prereq)) {
                missing.add(prereq);
            }
        }
        return missing;
    }

    public String register(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            return "FAILED: course " + courseCode + " does not exist";
        }
        if (course.getEnrolledStudents().contains(studentId)) {
            return "FAILED: " + studentId + " is already enrolled in " + courseCode;
        }
        if (course.getWaitlist().contains(studentId)) {
            return "FAILED: " + studentId + " is already on the waitlist for " + courseCode
                    + " (position " + (course.getWaitlist().indexOf(studentId) + 1) + ")";
        }
        List<String> missing = missingPrerequisites(studentId, course);
        if (!missing.isEmpty()) {
            return "FAILED: " + studentId + " is missing prerequisites " + missing + " for " + courseCode;
        }
        if (course.isFull()) {
            course.getWaitlist().addLast(studentId);
            return "WAITLISTED: " + studentId + " for " + courseCode
                    + " (position " + course.getWaitlist().size() + ")";
        }
        course.getEnrolledStudents().add(studentId);
        return "ENROLLED: " + studentId + " in " + courseCode;
    }

    public String drop(String studentId, String courseCode) {
        Course course = courses.get(courseCode);
        if (course == null) {
            return "FAILED: course " + courseCode + " does not exist";
        }
        if (course.getWaitlist().remove(studentId)) {
            return "REMOVED: " + studentId + " from the waitlist of " + courseCode;
        }
        if (!course.getEnrolledStudents().remove(studentId)) {
            return "FAILED: " + studentId + " is not registered for " + courseCode;
        }
        return "DROPPED: " + studentId + " from " + courseCode + promoteFromWaitlist(course);
    }

    private String promoteFromWaitlist(Course course) {
        if (course.isFull() || course.getWaitlist().isEmpty()) {
            return "";
        }
        String promoted = course.getWaitlist().pollFirst();
        course.getEnrolledStudents().add(promoted);
        return " -> PROMOTED " + promoted + " from the waitlist";
    }

    public void printCourse(String courseCode) {
        Course course = courses.get(courseCode);
        System.out.println(course == null ? "No course " + courseCode : course);
    }

    public static void main(String[] args) {
        CourseRegistrationPortal portal = new CourseRegistrationPortal();

        Course cs101 = new Course("CS101", "Programming Fundamentals", 3);
        Course cs201 = new Course("CS201", "Data Structures", 2);
        cs201.addPrerequisite("CS101");
        Course cs301 = new Course("CS301", "Algorithms", 2);
        cs301.addPrerequisite("CS101");
        cs301.addPrerequisite("CS201");

        portal.addCourse(cs101);
        portal.addCourse(cs201);
        portal.addCourse(cs301);

        for (String s : new String[]{"S1", "S2", "S3", "S4"}) {
            portal.markCompleted(s, "CS101");
        }

        System.out.println("=== Registration requests ===");
        System.out.println(portal.register("S1", "CS201"));
        System.out.println(portal.register("S2", "CS201"));
        System.out.println(portal.register("S3", "CS201"));
        System.out.println(portal.register("S4", "CS201"));
        System.out.println(portal.register("S5", "CS201"));
        System.out.println(portal.register("S1", "CS201"));
        System.out.println(portal.register("S3", "CS201"));
        System.out.println(portal.register("S1", "CS301"));
        System.out.println(portal.register("S1", "CS999"));
        System.out.println(portal.register("S5", "CS101"));
        portal.printCourse("CS201");

        System.out.println("\n=== Drops and waitlist promotion ===");
        System.out.println(portal.drop("S1", "CS201"));
        portal.printCourse("CS201");
        System.out.println(portal.drop("S4", "CS201"));
        System.out.println(portal.drop("S2", "CS201"));
        System.out.println(portal.drop("S9", "CS201"));
        portal.printCourse("CS201");

        System.out.println("\n=== All courses ===");
        for (Course c : portal.courses.values()) {
            System.out.println(c);
        }
    }
}
