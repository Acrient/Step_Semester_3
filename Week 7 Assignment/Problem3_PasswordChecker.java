public class Problem3_PasswordChecker {
    static final class PasswordChecker {
        private final String password;

        PasswordChecker(String password) {
            this.password = password;
        }

        String getStrength() {
            int length = password.length();
            if (length < 6) return "Weak";
            if (length <= 9) return "Medium";
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println(new PasswordChecker("abcd").getStrength());
        System.out.println(new PasswordChecker("abcdefgh").getStrength());
        System.out.println(new PasswordChecker("abcdefghijkl").getStrength());
    }
}
