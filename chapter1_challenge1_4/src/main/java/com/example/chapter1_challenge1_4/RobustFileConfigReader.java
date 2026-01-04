package com.example.chapter1_challenge1_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RobustFileConfigReader {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // 1. Tries to read from a file named config.txt.
            File configFile = new File("config.txt");
            reader = new BufferedReader(new FileReader(configFile));

            String line1 = reader.readLine();
            if (line1 == null) {
                throw new IOException("File is empty");
            }

            // 3. If the first line is read successfully, it should be a number representing a "config version."
            int version = Integer.parseInt(line1.trim());
            // If the version is less than 2, throw a custom exception InvalidConfigVersionException
            if (version < 2) {
                throw new InvalidConfigVersionException("Config version too old!");
            }

            // 4. The second line should be a file path.
            String line2 = reader.readLine();
            if (line2 == null) {
                throw new IOException("Config file missing second line.");
            }

            String filePath = line2.trim();
            File pathFile = new File(filePath);
            // Check if the file at that path exists. If it doesn't, throw a new IOException with a custom message.
            if (!pathFile.exists()) {
                throw new IOException("File at path " + filePath + " does not exist.");
            }

        } catch (FileNotFoundException e) {
            // 2. Implements multiple, specific catch blocks
            // FileNotFoundException: If the file doesn't exist.
            System.out.println("Error: Config file not found.");
        } catch (NumberFormatException e) {
            // NumberFormatException: If the first line cannot be parsed to an integer.
            System.out.println("Error: First line is not a valid number.");
        } catch (InvalidConfigVersionException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            // IOException: If a general reading error occurs.
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: An unexpected error occurred: " + e.getMessage());
        } finally {
            // 5. Use a finally block to print a message saying "Config read attempt finished."
            System.out.println("Config read attempt finished.");
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error closing reader: " + e.getMessage());
                }
            }
        }
    }
}