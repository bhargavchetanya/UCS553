public class Q7 {

    static int countDigits(int n) {
        if (n == 0) {
            return 1;
        }
        n = Math.abs(n);
        int count = 0;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {12345, 0, -9876, 7};
        for (int n : nums) {
            System.out.println("Number of digits in " + n + " = " + countDigits(n));
        }
    }
}

/*
Output:
Number of digits in 12345 = 5
Number of digits in 0 = 1
Number of digits in -9876 = 4
Number of digits in 7 = 1
*/
