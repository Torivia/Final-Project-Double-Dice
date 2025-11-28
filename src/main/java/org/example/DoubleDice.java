package org.example;

import java.util.Scanner;

/**
 * Contains the main game loop and betting logic for the Double Dice game.
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
            System.out.println("You have $" + moneyValue);

            // Validate betting amount: must be between 0 and current money
            do {
                System.out.println("How much money would you like to bet? (Enter 0 to quit)");
                bettingValue = input.nextDouble();

                if ((bettingValue < 0)) {
                    System.out.println("You can't bet negative numbers.");
                } else if (bettingValue > moneyValue){
                    System.out.println("Insufficient funds.");
                }
            } while ((bettingValue < 0) || (bettingValue > moneyValue));

            if (!(Math.abs(bettingValue - 0) < 0.0001)) {
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
        } while (!(Math.abs(bettingValue - 0) < 0.0001) && !(Math.abs(moneyValue - 0) < 0.0001));

        // Display final result after exiting loop
        if ((Math.abs(moneyValue - 0) < 0.0001)) {
            System.out.println("You ran out of money.");
        } else {
            System.out.println("See you next time.");
        }
    }
}
