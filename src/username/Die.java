/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Sully
 * Last Updated: 9/12/24
 */
package username;

import java.util.Random;

/**
 * The Die class can be created with just the number of sides,
 * can be rolled and stores last rolled value.
 */
public class Die {
    /**
     * The int MIN holds the minimum number of sides the die can have
     */
    public static final int MIN = 2;
    /**
     * The int MAX holds the maximum number of sides hte die can have
     */
    public static final int MAX = 100;
    private int currentValue;
    private final int numSides;
    private final Random random = new Random();

    /**
     *  This is the constructor, passed an int
     *  it checks to make sure the number of sides is allowed
     * @param x number of sides
     * @throws IllegalArgumentException if the number of sides is outside restrictions
     */
    public Die(int x) throws IllegalArgumentException{
        if(x>MAX||x<MIN){
            throw new IllegalArgumentException();
        }
        numSides = x;
    }

    /**
     * This method gives the user the current value of the top face of the die
     * @return returns the top value, unless it hasn't been rerolled then gives 0
     * @throws DieNotRolledException thrown when the current value isn't possible
     */
    public int getCurrentValue() throws DieNotRolledException{
        if(currentValue>numSides||currentValue<1){
            throw new DieNotRolledException();
        }
        int store = currentValue;
        currentValue = 0;
        return store;
    }

    /**
     * this method changes the value of the top side of the die
     */
    public void roll(){
        currentValue = random.nextInt(numSides)+1;
    }





}