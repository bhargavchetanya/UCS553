public class Q6 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int a = 12, b = 18;
        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));
        a = 7;
        b = 9;
        System.out.println("LCM of " + a + " and " + b + " = " + lcm(a, b));
    }
}

/*
Output:
LCM of 12 and 18 = 36
LCM of 7 and 9 = 63
*/
