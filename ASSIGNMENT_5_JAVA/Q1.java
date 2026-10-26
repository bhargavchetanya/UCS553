public class Q1 {

    public static <T extends Number> double sum(T[] arr) {
        double total = 0;
        for (T x : arr) {
            total += x.doubleValue();
        }
        return total;
    }

    public static void main(String[] args) {
        Integer[] ints = {10, 20, 30, 40, 50};
        Float[] floats = {1.5f, 2.5f, 3.5f, 4.5f};
        Double[] doubles = {2.25, 3.75, 10.5, 6.0};

        System.out.println("Sum of integers: " + sum(ints));
        System.out.println("Sum of floats: " + sum(floats));
        System.out.println("Sum of doubles: " + sum(doubles));
    }
}

/*
Output:
Sum of integers: 150.0
Sum of floats: 12.0
Sum of doubles: 22.5
*/
