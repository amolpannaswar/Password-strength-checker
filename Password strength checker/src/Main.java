import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecialChar = !password.matches("[A-Za-z0-9]*");

        int strength = calculateStrength(length, hasUppercase, hasLowercase, hasDigit, hasSpecialChar);

        System.out.println("Password Strength: " + getStrengthLabel(strength));
    }

    private static int calculateStrength(int length, boolean hasUppercase, boolean hasLowercase,
                                         boolean hasDigit, boolean hasSpecialChar) {
        int strength = 0;

        // Check length
        if (length >= 8) {
            strength++;
        }

        // Check for uppercase letters
        if (hasUppercase) {
            strength++;
        }

        // Check for lowercase letters
        if (hasLowercase) {
            strength++;
        }

        // Check for numbers
        if (hasDigit) {
            strength++;
        }

        // Check for special characters
        if (hasSpecialChar) {
            strength++;
        }

        return strength;
    }

    private static String getStrengthLabel(int strength) {
        switch (strength) {
            case 0:
            case 1:
                return "Very Weak";
            case 2:
                return "Weak";
            case 3:
                return "Moderate";
            case 4:
                return "Strong";
            case 5:
                return "Very Strong";
            default:
                return "Unknown";
        }
    }
}
