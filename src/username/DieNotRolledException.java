/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Sully
 * Last Updated: 9/12/24
 */
package username;

/**
 * DieNotRolled is for when the info given to the die class isn't allowed,
 * this exception gets thrown
 */
public class DieNotRolledException extends RuntimeException {
    public String getMessage(){
        return "The Die was not rolled.";
    }
}
