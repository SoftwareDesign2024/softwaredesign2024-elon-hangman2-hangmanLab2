package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * where the computer guesses letters based on a predictable pattern.
 *
 * @author Robert C. Duvall
 */
public class AutoGuesser extends GuesserBase {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";

    // word that is being guessed
    private String mySecretWord;
    // how many guesses are remaining
    private int myNumGuessesLeft;
    // what is shown to the user
    private DisplayWord myDisplayWord;
    // tracks letters guessed
    private StringBuilder myLettersLeftToGuess;
    // guesser state
    private String myLetters;
    private int myIndex;


    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public AutoGuesser (int numGuesses, int wordLength) {
    	super(numGuesses,wordLength);
        myNumGuessesLeft = numGuesses;
        myLettersLeftToGuess = new StringBuilder(ALPHABET);
        myLetters = LETTERS_ORDERED_BY_FREQUENCY;
        myIndex = 0;
    }

	@Override
	public String decideLetterToGuess()
	{
		Character guess = myLetters.charAt(myIndex++);
		return(guess.toString());
	}
}

    



