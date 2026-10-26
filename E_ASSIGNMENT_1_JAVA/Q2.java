public class Q2 {
    public static void main(String[] args) {
        char[] chars = {'a', 'Z', '7', '$'};
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                System.out.println(c + " is an Alphabet");
            } else {
                System.out.println(c + " is not an Alphabet");
            }
        }
    }
}

/*
Output:
a is an Alphabet
Z is an Alphabet
7 is not an Alphabet
$ is not an Alphabet
*/
