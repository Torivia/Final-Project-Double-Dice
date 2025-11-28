package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * DoubleDice Game. Contains the main game loop and betting logic for the Double Dice game.
 * @author Tori Vargas
 */
public class DoubleDice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Die dice1 = new Die();
        Die dice2 = new Die();
        double moneyValue = 100.00;
        double bettingValue;

        // Main game loop: continues until player quits or runs out of money
        do {
            System.out.printf("\nYou have $%.2f\n", moneyValue);

            // Validate betting amount: must be between 0 and current money
            while (true) {
                try {
                    System.out.println("How much money would you like to bet? (Enter 0 to quit)");
                    bettingValue = input.nextDouble();

                    if ((bettingValue < 0)) {
                        System.out.println("You can't bet negative numbers.");
                    } else if (bettingValue > moneyValue) {
                        System.out.println("Insufficient funds.");
                    } else {
                        break;
                    }
                }
                catch (InputMismatchException excptn) { // Watching out for inputs that aren't numeric values
                    System.out.println("Invalid betting value. Please input a number");
                    input.next();
                }
            }

            if (!(Math.abs(bettingValue - 0) < 0.0001)) { // Check if user wants to quit
                // Roll both dice
                dice1.roll();
                dice2.roll();

                // Compare dice values to determine win or loss
                if (dice1.equals(dice2)) {
                    System.out.println("You rolled a " + dice1 + " and a " + dice2);
                    System.out.printf("You win $%.2f\n", bettingValue);
                    moneyValue += bettingValue;
                } else {
                    System.out.println("You rolled a " + dice1 + " and a " + dice2);
                    System.out.printf("You lose $%.2f\n", bettingValue);
                    moneyValue -= bettingValue;
                }
            }
        } while (!(Math.abs(bettingValue - 0) < 0.0001) && !(Math.abs(moneyValue - 0) < 0.0001)); // Check if user wants to quit or is broke

        // Display final result after exiting loop
        if ((Math.abs(moneyValue - 0) < 0.0001)) { // Check if user is broke
            System.out.println("\nYou ran out of money.\n" +
                                "Better luck next time.");
        } else {
            System.out.println("\nSee you next time.");
        }
    }
}
