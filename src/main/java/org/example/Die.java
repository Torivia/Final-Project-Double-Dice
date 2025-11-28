package org.example;

import java.util.HashMap;
import java.util.Random;

/**
 * Die class. Simulates rolling a six-sided die with
 * string conversion support.
 * @author Tori Vargas
 */
public class Die {
    private HashMap<Integer, String>  dieNumToWord = new HashMap<>();
    private int dieValue;
    private Random randomObj;

    /**
     * Default constructor initializing the die value to 0
     * and populating the dieNumToWord HashMap.
     */
    public Die() {
        this.dieValue = 0;
        this.randomObj = new Random();
        initializeMap();
    }

    /**
     * Returns the current die value.
     */
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
     * Checks if both dieValues are equal.
     * @param die2 allows for dieValue comparison.
     * @return true if both dice have the same value, false otherwise
     */
    public boolean equals(Die die2) {
        boolean isEqual;
        int secondDieValue;

        secondDieValue = die2.getDieValue();
        isEqual = (dieValue == secondDieValue);

        return isEqual;
    }

    /**
     * Allows dieValue to be used as key.
     * @return a String value representing dieValue in String form.
     */
    @Override
    public String toString() {
        String numConverted;

        numConverted = dieNumToWord.get(dieValue);

        return numConverted;
    }

    /**
     * Populates HashMap dieNumToWord. Each number is matched conveniently to it's word form
     */
    private void initializeMap() {
        dieNumToWord.put(1, "one");
        dieNumToWord.put(2, "two");
        dieNumToWord.put(3, "three");
        dieNumToWord.put(4, "four");
        dieNumToWord.put(5, "five");
        dieNumToWord.put(6, "six");
    }
}
