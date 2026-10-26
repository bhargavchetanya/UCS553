public class Q5 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 36, b = 60;
        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
        a = 17;
        b = 5;
        System.out.println("GCD of " + a + " and " + b + " = " + gcd(a, b));
    }
}

/*
Output:
GCD of 36 and 60 = 12
GCD of 17 and 5 = 1
*/
