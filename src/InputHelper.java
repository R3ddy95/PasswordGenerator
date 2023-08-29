package src;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static void handleUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do you want to include Uppercase? (y/n): ");
        boolean includeUpperCase = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you want to include Lowercase? (y/n): ");
        boolean includeLowerCase = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you want to include numbers? (y/n): ");
        boolean includeDigits = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Do you want to include special symbols? (y/n): ");
        boolean includeSpecialChars = scanner.nextLine().trim().equalsIgnoreCase("y");

        int length = 0;
        boolean validLength = false;

        while (!validLength) {
            try {
                System.out.print("Enter the desired length of the password (between 6 and 20): ");
                length = scanner.nextInt();

                if (length >= 6 && length <= 20) {
                    validLength = true;
                } else {
                    System.out.println("Password length must be between 6 and 20 characters.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input from the scanner
            }
        }

        String password = PasswordGeneratorLogic.generatePassword(length, includeUpperCase, includeLowerCase,
                includeDigits, includeSpecialChars);
        System.out.println("The Password generated is: " + password);

        scanner.close();
    }
}
