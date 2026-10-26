import java.util.Optional;

public class Q2 {
    public static void main(String[] args) {
        Optional<String> email = Optional.of("chetanya@thapar.edu");
        Optional<String> noEmail = Optional.empty();

        System.out.print("Email using ifPresent: ");
        email.ifPresent(e -> System.out.println(e));
        noEmail.ifPresent(e -> System.out.println("This will not print"));

        String e1 = email.orElse("default@thapar.edu");
        String e2 = noEmail.orElse("default@thapar.edu");
        System.out.println("orElse on present email: " + e1);
        System.out.println("orElse on empty email: " + e2);

        System.out.println("orElseThrow on present email: " + email.orElseThrow());
        try {
            String e3 = noEmail.orElseThrow(() -> new IllegalArgumentException("Email not found for student"));
            System.out.println(e3);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    }
}

/*
Output:
Email using ifPresent: chetanya@thapar.edu
orElse on present email: chetanya@thapar.edu
orElse on empty email: default@thapar.edu
orElseThrow on present email: chetanya@thapar.edu
Exception caught: Email not found for student
*/
