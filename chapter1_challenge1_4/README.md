# Robust File Config Reader

This program demonstrates robust file handling and exception handling in Java. It attempts to read a configuration file and validate its contents.

## Functionality

1.  **Reads `config.txt`:** Attempts to open and read a file named `config.txt`.
2.  **Version Check:** Reads the first line as an integer version number. Throws a custom `InvalidConfigVersionException` if the version is less than 2.
3.  **Path Verification:** Reads the second line as a file path and verifies if that file exists.
4.  **Exception Handling:** Catches and handles specific exceptions:
    *   `FileNotFoundException`
    *   `NumberFormatException`
    *   `InvalidConfigVersionException`
    *   `IOException`
    *   General `Exception`
5.  **Cleanup:** Uses a `finally` block to ensure the file reader is closed properly.

## Setup

To run successfully, ensure a `config.txt` file exists in the project root with:
1.  A version number (integer >= 2) on the first line.
2.  A valid file path on the second line.
