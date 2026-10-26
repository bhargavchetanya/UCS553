public class Q9 {

    static long power(int base, int exp) {
        long result = 1;
        for (int i = 1; i <= exp; i++) {
            result = result * base;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("2 ^ 10 = " + power(2, 10));
        System.out.println("5 ^ 3 = " + power(5, 3));
        System.out.println("7 ^ 0 = " + power(7, 0));
        System.out.println("Using Math.pow: 3 ^ 4 = " + (int) Math.pow(3, 4));
    }
}

/*
Output:
2 ^ 10 = 1024
5 ^ 3 = 125
7 ^ 0 = 1
Using Math.pow: 3 ^ 4 = 81
*/
