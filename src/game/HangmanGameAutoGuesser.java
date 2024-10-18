package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * where the computer guesses letters based on a predictable pattern.
 *
 * @author Robert C. Duvall
 * 
 * refactored @author jamie mancuso
 */
public class HangmanGameAutoGuesser extends Guesser {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";

    // guesser state
    private String myLetters;
    private int myIndex;


    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    @Override
    public Character getGuess() {
    	return myLetters.charAt(myIndex++);
    }
    
    public HangmanGameAutoGuesser (HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	super(ALPHABET, numGuesses);
        myLetters = LETTERS_ORDERED_BY_FREQUENCY;
        myIndex = 0;
    }

}
