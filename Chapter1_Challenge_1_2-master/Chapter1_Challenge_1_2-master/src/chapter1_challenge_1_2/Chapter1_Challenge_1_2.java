package chapter1_challenge_1_2;

public class Chapter1_Challenge_1_2 {

    public static void main(String[] args) {
        System.out.println("--- Lottery Number Analyzer ---");
        
        // 1. Array Initialization
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};
        
        // Variables to track the winner
        double highestAverage = -1.0;
        String winningTicket = "";

        // 2. Outer Loop: Use a for-each loop to process each ticket string
        for (String currentTicket : winningNumbers) {
            System.out.println("\nAnalyzing: " + currentTicket);
            
            // 3. String Manipulation
            // Remove the dashes
            String cleanDigits = currentTicket.replace("-", ""); 
            
            // Convert the clean string to an array of characters
            char[] digitChars = cleanDigits.toCharArray(); 
            final int NUM_DIGITS = digitChars.length; // This should be 10

            // Variables for the current ticket's calculation
            int digitSum = 0;
            
            // 4. Inner Loop: Use a standard for loop to iterate over the digits
            for (int i = 0; i < NUM_DIGITS; i++) {
                // Convert the character digit to its numeric integer value
                int digitValue = Character.getNumericValue(digitChars[i]); 
                digitSum += digitValue;
            }
            
            // 5. Calculate Average (Must be double/floating-point division)
            double digitAverage = (double) digitSum / NUM_DIGITS; 
            
            // Print the current ticket's analysis
            System.out.printf("  Digit Sum: %d, Digit Average: %.1f%n", digitSum, digitAverage);

            // 6. Track the Winner
            // Find which winning number has the highest average
            if (digitAverage > highestAverage) {
                highestAverage = digitAverage;
                winningTicket = currentTicket;
            }
        } // End of the for-each loop

        // 7. Final Output
        System.out.println("\n-------------------------------------");
        System.out.printf("The overall WINNING TICKET is: %s%n", winningTicket);
        System.out.printf("With the Highest Average: %.1f%n", highestAverage);
        System.out.println("-------------------------------------");
    }
}