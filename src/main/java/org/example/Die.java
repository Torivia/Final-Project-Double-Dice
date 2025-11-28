//TODO Constructor method:  Initializes the die’s value to 0 and instantiates the Random object.
//TODO roll() method – uses the Random object to simulate a die roll between 1 and 6. NOTE: import random
//TODO equals(Die die2) method – returns Boolean true if both die have equal values, false otherwise.NOTE: if-statement for which bool is returned
//TODO toString() method – returns the String “one”, “two”, “three”, “four”, “five”, or “six” depending on the value of the die. NOTE: nested if-statement to determine the value and then assign it to the correct string for efficiency :D?

//Die Class – Class that simulates a six-sided die.

package org.example;
import java.util.HashMap;
import java.util.Random;

public class Die {
    HashMap<Integer, String>  dieNumToWord = new HashMap<>();
    private int dieValue;
    private Random randomObj;

    /**
     * Default constructor initializing Random Object
     * sets dieValue field to 0.
     */
    public Die() {
        this.dieValue = 0;
        this.randomObj = new Random();
        initializeMap();
    }

    private void initializeMap() {
        dieNumToWord.put(1, "one");
        dieNumToWord.put(2, "two");
        dieNumToWord.put(3, "three");
        dieNumToWord.put(4, "four");
        dieNumToWord.put(5, "five");
        dieNumToWord.put(6, "six");
    }

    public int getDieValue() {
        return dieValue;
    }

    /**
     * Sets dieValue to a number ranging from 1-6
     */
    public void roll() {
        int rolledValue;
        rolledValue = randomObj.nextInt(1, 7);

        dieValue = rolledValue;
    }

    /**
     * Sets dieValue to a number ranging from 1-6
     */
    public boolean equals(Die die2) {
        boolean isEqual;
        int secondDieValue;

        secondDieValue = die2.getDieValue();
        isEqual = (dieValue == secondDieValue);

        return isEqual;
    }

    @Override
    public String toString() {
        String numConverted;

        numConverted = dieNumToWord.get(dieValue);

        return numConverted;
    }
}
