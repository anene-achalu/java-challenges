package com.example.chapter1_challenge_1_3;

import java.util.Random;
import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int health = 100;
        boolean defeated = false;

        System.out.println("Welcome to the Dungeon Game!");
        System.out.println("You have 100 health. Survive 5 rooms to win.");

        for (int room = 1; room <= 5; room++) {
            System.out.println("\nEntering room " + room + "...");
            int event = rand.nextInt(3) + 1; // Generates 1, 2, or 3

            switch (event) {
                case 1: // Trap
                    health -= 20;
                    System.out.println("A trap sprung! Health is now " + health + ".");
                    break;
                case 2: // Healing Potion
                    health += 15;
                    if (health > 100) {
                        System.out.println("You found a healing potion! Health is now " + health + " -> capped to 100.");
                        health = 100;
                    } else {
                        System.out.println("You found a healing potion! Health is now " + health + ".");
                    }
                    break;
                case 3: // Monster
                    System.out.println("A monster appears!");
                    int monsterNumber = rand.nextInt(5) + 1;
                    int guess;
                    boolean firstGuess = true;

                    do {
                        if (firstGuess) {
                            System.out.print("Guess a number (1-5) to defeat it: ");
                            firstGuess = false;
                        } else {
                            System.out.print("Wrong! Try again: ");
                        }

                        while (!scanner.hasNextInt()) {
                            scanner.next(); // consume invalid input
                            System.out.print("Invalid input. Enter a number (1-5): ");
                        }
                        guess = scanner.nextInt();
                    } while (guess != monsterNumber);

                    System.out.println("You defeated the monster!");
                    System.out.println("Current Health: " + health);
                    break;
            }

            if (health <= 0) {
                System.out.println("You have been defeated in room " + room + ".");
                defeated = true;
                break;
            }
        }

        if (!defeated) {
            System.out.println("\nYou cleared the dungeon! Victorious with " + health + " health!");
        }

        scanner.close();
    }
}
