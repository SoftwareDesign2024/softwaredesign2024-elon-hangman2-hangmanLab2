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
 */
public class HangmanGame {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // word that is being guessed
    
    // how many guesses are remaining
    private int myNumGuessesLeft;
    
    
    //references to both the guesser and executioner for use in Hangman game
    private GuesserBase guesser;
    private ExecutionerBase executioner;
    
   


    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame (HangmanDictionary dictionary, int numLetters, int numMisses, ExecutionerBase executioner,GuesserBase guesser) {
        this.executioner = executioner;
        executioner.setGameVar(this);
        this.guesser = guesser;
        
        guesser.setGameVar(this);
        
        guesser.makeDisplayWord(new DisplayWord(executioner.getSecretWord()));
    }
    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            String guess = guesser.decideLetterToGuess();
            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
                this.guesser.makeGuess(guess.toLowerCase().charAt(0));
                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                }
                else if (isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            }
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        System.out.println("The secret word was " + this.executioner.getSecretWord());
    }
    // Returns true only if the guesser has guessed all letters in the secret word.
    private boolean isGameWon () {
        return this.guesser.getDisplayword().equals(this.executioner.getSecretWord());
    }
    
    //intermediary method for returning the value of Executioner's checkGuessInSecret without exposing to
    //Guesser
    public boolean checkGuess(char guess)
    {
    	return this.executioner.checkGuessInSecret(guess);
    	
    }
    
    public DisplayWord getDisplayWord()
    {
    	return this.guesser.getDisplayword();
    }


    // Returns true only if the guesser has used up all their chances to guess.
    private boolean isGameLost () {
        return guesser.getNumberofGuesses() == 0;
    }

    // Print game stats
    private void printStatus () {
    	DisplayWord guesserDisplayword = this.guesser.getDisplayword();
        System.out.println(guesserDisplayword);
        System.out.println("# misses left = " + this.guesser.getNumberofGuesses());
        System.out.println("letters not yet guessed = " + this.guesser.getLettersLeftToGuess());
        // NOT PUBLIC, but makes it easier to test
        System.out.println("*** " + this.executioner.getSecretWord());
        System.out.println();
    }

    //notify the Guesser of any updates to their DisplayWord, takes a char and a String and passes
    //them to the respective Guesser version of this function.
	public void updateDisplayWord(char guess, String mySecretWord) {
		this.guesser.updateDisplayWord(guess,mySecretWord);
		
	}
}
