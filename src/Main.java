import game.HangmanGame;
import game.HangmanGameAutoGuesser;
import game.HangmanGameCheatingComputer;
import util.HangmanDictionary;
import game.*;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 * 
 * 
 * refactored @author jamie mancuso
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    public static void main (String[] args) {
    	Executioner cheat = new HangmanGameCheatingComputer(new HangmanDictionary(DICTIONARY), NUM_LETTERS);
    	Guesser auto = new HangmanGameAutoGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES);
    	Executioner normalEx = new Executioner(new HangmanDictionary(DICTIONARY), NUM_LETTERS);
    	Guesser manual = new Guesser(ALPHABET, NUM_MISSES);
        //new HangmanGameInteractiveGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
        //new HangmanGameAutoGuesser(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
    	//new HangmanGameCheatingComputer(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES).play();
    	new HangmanGame(auto, cheat).play();
    }
}
