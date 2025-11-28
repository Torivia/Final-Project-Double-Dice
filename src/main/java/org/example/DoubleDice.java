//TODO: Contain main logic for playing the game.
//TODO: Reference your Die Class and corresponding methods for die rolling.
//TODO: May either have statements all in a main() method or split logic up in separate methods.

//DoubleDice Class – Class that contains game looping and logic.

package org.example;
import java.util.InputMismatchException;
import java.util.Scanner; //for input!

public class DoubleDice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Die dice1 = new Die();
        Die dice2 = new Die();
        double moneyValue = 100.00;
        double bettingValue = 0;

        System.out.println("You have $" + moneyValue);
        do {
            System.out.println("How much money would you like to bet?");
            bettingValue = input.nextDouble();
        } while ((bettingValue < 0) || (bettingValue > moneyValue));

        while (!(Math.abs(bettingValue - 0) < 0.0001) && !(Math.abs(moneyValue - 0) < 0.0001)) {
            System.out.printf("$%.2f\n", moneyValue );
            dice1.roll();
            dice2.roll();

            //TODO: if (die1.equals(die2)) then player wins and add bettingValue, else lose and take away bettingValue
            if (dice1.equals(dice2)) {
                System.out.println("dieValue1 = " + dice1.getDieValue());
                System.out.println("dieValue2 = " + dice2.getDieValue());
                System.out.println("won");
                moneyValue += bettingValue;
            } else {
                System.out.println("dieValue1 = " + dice1.getDieValue());
                System.out.println("dieValue2 = " + dice2.getDieValue());
                System.out.println("lost");
                moneyValue -= bettingValue;
            }
            //TODO: outside of if/else, print result using toString and then ask for bettingVal input again
            bettingValue = input.nextDouble();
        }
        if ((Math.abs(moneyValue - 0) < 0.0001)) {
            System.out.println("out of money");
        } else {
            System.out.println("cya winner");
        }

        System.out.println("end of game");

    }
}
