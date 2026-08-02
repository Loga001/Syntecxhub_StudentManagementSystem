import java.util.Scanner;

public class InputValidator {

    private static Scanner sc = new Scanner(System.in);

    // Read Integer
    public static int getInt(String message) {

        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid integer.");
            }
        }
    }

    // Read Double
    public static double getDouble(String message) {

        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine());

                if (value < 0 || value > 10) {
                    System.out.println("CGPA must be between 0 and 10.");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid decimal value.");
            }
        }
    }

    // Read String
    public static String getString(String message) {

        while (true) {

            System.out.print(message);
            String input = sc.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }
}