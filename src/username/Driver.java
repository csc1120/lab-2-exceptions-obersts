/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Sully
 * Last Updated: 09/16/24
 */
package username;

import java.util.Scanner;

/**
 * The Driver class is designed to complete all jobs required of the code using the methods
 * and other classes.
 */
public class Driver {
    /**
     * The MIN_DICE int is a final int the is used to check if the number of
     * dice inputs meets the minimum requirement of two.
     */
    public static final int MIN_DICE = 2;
    /**
     * The MAX_DICE int is a final int the is used to check if the number of
     * dice input meets the maximum parameter.
     */
    public static final int MAX_DICE = 10;

    public static void main(String[] args){
        int[] input = getInput();
        int numDice = input[0];
        int numSides = input[1];
        int numRolls = input[2];
        createDice(numDice, numSides);
        int[] rolls = rollDice(createDice(numDice, numSides), numSides, numRolls);
        report(numDice, rolls, findMax(rolls));


    }
    private static int[] getInput(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the number of dice to roll, how many sides");
        System.out.println("the dice have, and how many rolls to complete, separating");
        System.out.println("separating the values by a space.");
        System.out.println();
        boolean validate = false;
        int[] ret = new int[0];
        do{
            try{
                System.out.println("Enter configuration:");
                String input = in.nextLine();
                String[] split = input.split(" ");
                int[] back = new int[split.length];
                if(back.length!=3){
                    throw new IllegalArgumentException();
                }
                for(int i = 0; i<3; i++){
                    back[i] = Integer.parseInt(split[i]);
                }
                int numDice = back[0];
                if(numDice > MAX_DICE || numDice < MIN_DICE){
                    throw new IllegalArgumentException();
                } else {
                    ret = back;
                    validate = true;
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a numerical value within the range.");
            } catch (IllegalArgumentException e){
                System.err.println("Incorrect number of values entered, try again.");
            }
        } while(!validate);
        return ret;
    }
    private static Die[] createDice(int numDice, int numSides) throws IllegalArgumentException{
        Die[] back = new Die[numDice];
        for(int i = 0; i<numDice; i++){
            back[i] = new Die(numSides);
        }
        return back;
    }
    private static int[] rollDice(Die[] dice, int numSides, int numRolls){
        int[] back = new int[numSides*dice.length-dice.length+1];
        int total = 0;
        for(int i = 0; i<numRolls; i++){
            for (Die die : dice) {
                die.roll();
                total += die.getCurrentValue();
            }
            back[total-dice.length]++;
            total = 0;
        }
        return back;
    }
    private static int findMax(int[] rolls){
        int max = 0;
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        return max;
    }
    @SuppressWarnings("checkstyle:MagicNumber")
    private static void report(int numDice, int[] rolls, int max){
        int scale;
        int scaleMin = 10;
        if(max>=scaleMin){
            scale = max/10;
        } else{
            scale = 1;
        }


        for(int i = 0; i < rolls.length; i++){
            System.out.printf("%d :%d", numDice+i, rolls[i]);
            System.out.printf("   %s", "*".repeat(Math.max(0, rolls[i]/scale)));
            System.out.println();
        }








    }
}