public class Q8 {

    static int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] nums = {12345, 1200, 908};
        for (int n : nums) {
            System.out.println("Reverse of " + n + " = " + reverse(n));
        }
    }
}

/*
Output:
Reverse of 12345 = 54321
Reverse of 1200 = 21
Reverse of 908 = 809
*/
