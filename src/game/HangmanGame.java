package game;

import util.ConsoleReader;
import util.DisplayWord;
import util.HangmanDictionary;


/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 * 
 * //refactored @author jamie mancuso
 */
public class HangmanGame {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

   
    

    private Guesser guesser;
    private Executioner execution;
    
    


    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame (Guesser guess, Executioner execute) {
    	guesser = guess;
        execution = execute;
    }
    public HangmanGame (HangmanDictionary dictionary, int wordLength, int numGuesses) {
    	guesser = new Guesser(ALPHABET,numGuesses);
        execution = new Executioner(dictionary, wordLength);
    }
    


    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();
        	Boolean checkGuess = execution.checkGuessInSecret(guesser.getGuess());
            guesser.makeGuess(guesser.getGuess(), checkGuess);
            if (isGameLost()) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            }
            else if (execution.isGameWon()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            }
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        
    }


   

   
    // Returns true only if the guesser has guessed all letters in the secret word.


    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return guesser.getmyNumGuessesLeft() == 0;
    }

    // Print game stats
    private void printStatus () {
        System.out.println( execution.getMyDisplayWord());
        System.out.println("# misses left = " + guesser.getmyNumGuessesLeft());
        System.out.println("letters not yet guessed = " + guesser.getMyLettersLeftToGuess());
        // NOT PUBLIC, but makes it easier to test
        //System.out.println("*** " + mySecretWord);
        System.out.println();
    }
}
