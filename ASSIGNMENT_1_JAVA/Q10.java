public class Q10 {

    static boolean isPalindrome(int n) {
        int original = n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return original == rev;
    }

    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {121, 12321, 123};
        for (int n : nums) {
            System.out.println(n + (isPalindrome(n) ? " is a Palindrome" : " is not a Palindrome"));
        }
        String[] words = {"Madam", "racecar", "java"};
        for (String w : words) {
            System.out.println(w + (isPalindrome(w) ? " is a Palindrome" : " is not a Palindrome"));
        }
    }
}

/*
Output:
121 is a Palindrome
12321 is a Palindrome
123 is not a Palindrome
Madam is a Palindrome
racecar is a Palindrome
java is not a Palindrome
*/
