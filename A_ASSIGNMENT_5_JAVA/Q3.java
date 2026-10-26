import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private String name;
    private T[] marks;
    private double maxMarks;

    Result(String name, T[] marks, double maxMarks) {
        this.name = Objects.requireNonNull(name, "Student name cannot be null");
        this.marks = marks;
        this.maxMarks = maxMarks;
    }

    Optional<T[]> getMarks() {
        return Optional.ofNullable(marks);
    }

    double total() {
        double sum = 0;
        for (T m : marks) {
            sum += m.doubleValue();
        }
        return sum;
    }

    double average() {
        return total() / marks.length;
    }

    double percentage() {
        return total() / (maxMarks * marks.length) * 100;
    }

    boolean isPassed(double threshold) {
        return percentage() >= threshold;
    }

    void display(double threshold) {
        System.out.println("Student: " + name);
        if (getMarks().isPresent()) {
            System.out.print("Marks: ");
            for (T m : marks) {
                System.out.print(m + " ");
            }
            System.out.println();
            System.out.println("Total: " + total());
            System.out.printf("Average: %.2f%n", average());
            System.out.printf("Percentage: %.2f%%%n", percentage());
            System.out.println("Status: " + (isPassed(threshold) ? "PASS" : "FAIL"));
        } else {
            System.out.println("Marks not available");
        }
        System.out.println();
    }
}

public class Q3 {
    public static void main(String[] args) {
        double threshold = 40;

        Integer[] m1 = {78, 85, 66, 90, 72};
        Result<Integer> r1 = new Result<>("Chetanya", m1, 100);
        r1.display(threshold);

        Double[] m2 = {32.5, 28.0, 41.5, 35.0};
        Result<Double> r2 = new Result<>("Rahul", m2, 100);
        r2.display(threshold);

        Result<Integer> r3 = new Result<>("Aman", null, 100);
        r3.display(threshold);

        try {
            Result<Integer> r4 = new Result<>(null, m1, 100);
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
Output:
Student: Chetanya
Marks: 78 85 66 90 72
Total: 391.0
Average: 78.20
Percentage: 78.20%
Status: PASS

Student: Rahul
Marks: 32.5 28.0 41.5 35.0
Total: 137.0
Average: 34.25
Percentage: 34.25%
Status: FAIL

Student: Aman
Marks not available

Error: Student name cannot be null
*/
