public class Q1 {

    static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] years = {2024, 1900, 2000, 2026};
        for (int y : years) {
            if (isLeap(y)) {
                System.out.println(y + " is a Leap Year");
            } else {
                System.out.println(y + " is not a Leap Year");
            }
        }
    }
}

/*
Output:
2024 is a Leap Year
1900 is not a Leap Year
2000 is a Leap Year
2026 is not a Leap Year
*/
