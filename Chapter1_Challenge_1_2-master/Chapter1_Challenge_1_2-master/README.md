# Lottery Number Analyzer

This Java program analyzes a set of lottery ticket numbers to determine the "winning" ticket based on the highest average digit value.

## Functionality

1.  **Input:** Initializes an array of lottery ticket strings (e.g., "12-34-56-78-90").
2.  **Processing:**
    *   Iterates through each ticket string.
    *   Removes separators (dashes) to isolate the digits.
    *   Calculates the sum of all digits in the ticket.
    *   Calculates the average value of the digits.
3.  **Comparison:** Tracks the ticket with the highest calculated average.
4.  **Output:** Displays the analysis for each ticket and announces the overall winning ticket with its average.

## Key Concepts

*   String manipulation (`replace`, `toCharArray`)
*   Loops (for-each, standard for loop)
*   Character to integer conversion
*   Floating-point arithmetic for averages
