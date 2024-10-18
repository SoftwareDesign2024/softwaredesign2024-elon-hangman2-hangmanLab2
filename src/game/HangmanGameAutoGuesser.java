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
public class HangmanGameAutoGuesser extends Guesser {
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
    public HangmanGameAutoGuesser (HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	super(ALPHABET, numGuesses);
        mySecretWord = getSecretWord(dictionary, wordLength);
        myDisplayWord = new DisplayWord(mySecretWord);
        myLetters = LETTERS_ORDERED_BY_FREQUENCY;
        myIndex = 0;
    }

    /**
     * Play one complete game.
     */
   
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            Character guess = myLetters.charAt(myIndex++);
            makeGuess(guess);
            if (isGameLost()) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            }
            else if (isGameWon()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            }
        }
        System.out.println("The secret word was " + mySecretWord);
    }


    // Process a guess by updating the necessary internal state.
    private void makeGuess (char guess) {
        // do not count repeated guess as a miss
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (! checkGuessInSecret(guess)) {
                myNumGuessesLeft -= 1;
            }
        }
    }

    // Record that a specific letter was guessed
    private void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }

    // Returns true only if given guess is in the secret word.
    private boolean checkGuessInSecret (char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }

    // Returns a secret word.
    private String getSecretWord (HangmanDictionary dictionary, int wordLength) {
        String result = ConsoleReader.promptString("Choose a secret word that is " + wordLength + " letters long: ");
        while (! dictionary.contains(result, wordLength)) {
            result = ConsoleReader.promptString("That word is not recognized, please choose another: ");
        }
        return result;
    }

    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon () {
        return myDisplayWord.equals(mySecretWord);
    }

    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return myNumGuessesLeft == 0;
    }

    // Print game stats
    private void printStatus () {
        System.out.println(myDisplayWord);
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.println("letters not yet guessed = " + myLettersLeftToGuess);
        // NOT PUBLIC, but makes it easier to test
        System.out.println("*** " + mySecretWord);
        System.out.println();
    }
}
