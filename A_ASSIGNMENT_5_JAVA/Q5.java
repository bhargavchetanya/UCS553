import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

class Utility {

    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Q5 {
    public static void main(String[] args) {
        System.out.println("isEqual(\"java\", \"java\"): " + Utility.isEqual("java", "java"));
        System.out.println("isEqual(\"java\", \"python\"): " + Utility.isEqual("java", "python"));
        System.out.println("isEqual(25, 25): " + Utility.isEqual(25, 25));
        System.out.println("isEqual(10.5, 20.5): " + Utility.isEqual(10.5, 20.5));
        System.out.println();

        Optional<String> name = Optional.of("Chetanya");
        Optional<String> empty = Optional.empty();
        Optional<Integer> num = Optional.empty();
        System.out.println("getDefault(Optional[Chetanya], \"Guest\"): " + Utility.getDefault(name, "Guest"));
        System.out.println("getDefault(Optional.empty, \"Guest\"): " + Utility.getDefault(empty, "Guest"));
        System.out.println("getDefault(Optional.empty, 0): " + Utility.getDefault(num, 0));
        System.out.println();

        System.out.println("max(\"apple\", \"mango\"): " + Utility.max("apple", "mango"));
        System.out.println("max(45, 78): " + Utility.max(45, 78));
        System.out.println("max(3.14, 2.71): " + Utility.max(3.14, 2.71));
        LocalDate d1 = LocalDate.of(2026, 1, 26);
        LocalDate d2 = LocalDate.of(2026, 8, 15);
        System.out.println("max(" + d1 + ", " + d2 + "): " + Utility.max(d1, d2));
        System.out.println();

        String s = null;
        System.out.println("isNull(null): " + Utility.isNull(s));
        System.out.println("isNull(\"hello\"): " + Utility.isNull("hello"));
        System.out.println("isNull(100): " + Utility.isNull(100));
    }
}

/*
Output:
isEqual("java", "java"): true
isEqual("java", "python"): false
isEqual(25, 25): true
isEqual(10.5, 20.5): false

getDefault(Optional[Chetanya], "Guest"): Chetanya
getDefault(Optional.empty, "Guest"): Guest
getDefault(Optional.empty, 0): 0

max("apple", "mango"): mango
max(45, 78): 78
max(3.14, 2.71): 3.14
max(2026-01-26, 2026-08-15): 2026-08-15

isNull(null): true
isNull("hello"): false
isNull(100): false
*/
