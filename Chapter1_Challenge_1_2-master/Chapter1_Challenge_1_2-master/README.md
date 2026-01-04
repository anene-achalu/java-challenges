# Challenge 1.2: The Lottery Number Analyzer (Arrays & Strings)

## Problem Description
This program analyzes an array of lottery ticket strings. Each ticket is a string containing 10 digits separated by dashes (e.g., "12-34-56-78-90").

The program performs the following steps for each ticket:
1. Removes the dashes to isolate the 10 digits.
2. Uses a **standard `for` loop** to calculate the **sum of all 10 digits** on the ticket.
3. Calculates the **average** of the digits (Sum / 10).
4. Uses a **`for-each` loop** to iterate over all tickets and determine which one has the **highest average digit value**.

## Example Input/Output
| Ticket String | Clean Digits | Sum of Digits | Digit Average |
| :--- | :--- | :--- | :--- |
| `12-34-56-78-90` | `1234567890` | 45 | 4.5 |
| `33-44-11-66-22` | `3344116622` | 32 | 3.2 |
| `01-02-03-04-05` | `0102030405` | 15 | 1.5 |

**Final Expected Output:**
The overall WINNING TICKET is: 12-34-56-78-90
With the Highest Average: 4.5

## Reflection
This challenge successfully demonstrated the use of both repetition structures required: the **`for-each` loop** was used to iterate through the array of `String` tickets, and the **standard `for` loop** was necessary to iterate through the `char` array of digits within each ticket.

The most valuable lessons were:
1. **String Manipulation:** Using methods like `.replace()` and `.toCharArray()` to easily convert the raw data into a usable array of digits.
2. **Type Conversion:** Using `Character.getNumericValue()` to safely convert a `char` (like '5') into its `int` value (5).
