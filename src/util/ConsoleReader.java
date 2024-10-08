package util;

import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Provides variety of methods to simplify getting user input from console.
 * 
 * @author Owen Astrachan
 * @author Robert C. Duvall
 */
public class ConsoleReader {
    // by default, read input from the user's console
    private static Scanner in = new Scanner(new InputStreamReader(System.in));


    /**
     * Prompts the user to input a word.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static String promptString (String prompt) {
        System.out.print(prompt);
        return in.next();
    }

    /**
     * Prompts the user to input an integer value.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static int promptInt (String prompt) {
        int result = Integer.MIN_VALUE;
        do {
            try {
                result = Integer.parseInt(promptString(prompt));
            }
            catch (NumberFormatException e) {
                // do nothing, just prompt the user again
            }
        } while (result == Integer.MIN_VALUE);
        return result;
    }

    /**
     * Prompts the user to input an real value.
     * 
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    public static double promptDouble (String prompt) {
        double result = Double.MIN_VALUE;
        do {
            try {
                result = Double.parseDouble(promptString(prompt));
            }
            catch (NumberFormatException e) {
                // do nothing, just prompt the user again
            }
        } while (result == Double.MIN_VALUE);
        return result;
    }
}
