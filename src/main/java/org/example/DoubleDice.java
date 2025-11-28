//TODO: Contain main logic for playing the game.
//TODO: Reference your Die Class and corresponding methods for die rolling.
//TODO: May either have statements all in a main() method or split logic up in separate methods.

//DoubleDice Class – Class that contains game looping and logic.

package org.example;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner; //for input!

public class DoubleDice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Die dice1 = new Die();
        Die dice2 = new Die();
        double moneyValue = 100.00;
        double bettingValue = 0;

        System.out.println("Hello and welcome to the dice game!");
        do {
            System.out.println("Input a value :D dont be sneaky and try to put a negative value >:("); //TODO: throw exception that handles negative inputs
            bettingValue = input.nextDouble();
        } while ((bettingValue < 0) || (bettingValue > moneyValue)); //TODO maybe put this in a separate class :3? called "verifyBettingValue(input)" returns the new bettingValue? :3

        while (!(Math.abs(bettingValue - 0) < 0.0001) || !(Math.abs(moneyValue - 0) < 0.0001)) {

            dice1.roll();
            dice2.roll();

            //TODO: if (die1.equals(die2)) then player wins and add bettingValue, else lose and take away bettingValue

            //TODO: outside of if/else, print result using toString and then ask for bettingVal input again
        }

    }
}
