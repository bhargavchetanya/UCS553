public class Q3 {

    static long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int[] nums = {0, 5, 10};
        for (int n : nums) {
            System.out.println("Factorial of " + n + " = " + factorial(n));
        }
    }
}

/*
Output:
Factorial of 0 = 1
Factorial of 5 = 120
Factorial of 10 = 3628800
*/
