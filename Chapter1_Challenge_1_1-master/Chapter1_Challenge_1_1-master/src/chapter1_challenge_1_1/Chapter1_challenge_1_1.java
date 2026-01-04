package chapter1_challenge_1_1;

public class chapter1_challenge_1_1 {

    public static void main(String[] args) {
        // Input as specified in the scenario [cite: 21]
        final int CRYPTIC_MESSAGE = 13579;
        
        System.out.println("--- Cryptic Message Decoder ---");
        System.out.println("Input Message: " + CRYPTIC_MESSAGE);

        // --- Extracted Digits ---
        
        // 1. Extracts the last digit (9) using Modulus [cite: 24, 29]
        // Example: 13579 % 10 = 9
        int lastDigit = CRYPTIC_MESSAGE % 10;
        
        // 2. Extracts the first digit (1) using Division and Math.log10 [cite: 23, 30]
        // a) Find the number of digits: Math.log10(13579) ≈ 4.13. Floor + 1 = 5.
        int numDigits = (int)Math.log10(CRYPTIC_MESSAGE) + 1;
        
        // b) Calculate the divisor (10^(5-1) = 10000)
        int divisor = (int)Math.pow(10, numDigits - 1);
        
        // c) Divide to get the first digit: 13579 / 10000 = 1
        int firstDigit = CRYPTIC_MESSAGE / divisor;

        // 3. Extracts the second-last digit (7) [cite: 26]
        // Example: (13579 / 10) = 1357. Then 1357 % 10 = 7.
        int secondLastDigit = (CRYPTIC_MESSAGE / 10) % 10;

        // 4. Extracts the second digit (3) [cite: 26]
        // Example: (13579 / 1000) = 13. Then 13 % 10 = 3.
        int secondDigit = (CRYPTIC_MESSAGE / 1000) % 10;

        // --- Operations and Final Code ---

        // Finds the product of the first and last digit (1 * 9 = 9) [cite: 25]
        int product = firstDigit * lastDigit;

        // Finds the sum of the second digit and the second-last digit (3 + 7 = 10) [cite: 26]
        int sum = secondDigit + secondLastDigit;

        // Creates a final code by concatenating the product and the sum [cite: 27]
        // The empty string "" forces the integer math results to be concatenated as Strings.
        String finalCode = "" + product + sum; 

        // --- Output ---
        System.out.println("\nDecryption Analysis:");
        System.out.println("Product of First (" + firstDigit + ") and Last (" + lastDigit + "): " + product);
        System.out.println("Sum of Second (" + secondDigit + ") and Second-Last (" + secondLastDigit + "): " + sum);
        System.out.println("\nExpected Output: The decrypted code is: 910 ");
        System.out.println("The decrypted code is: " + finalCode);
    }
}