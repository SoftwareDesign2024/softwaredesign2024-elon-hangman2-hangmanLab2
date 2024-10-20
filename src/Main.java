import game.HangmanGame;
import game.AutoGuesser;
import game.CheatingExecutioner;
import game.HonestExecutioner;
import game.ManualGuesser;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;

    
    //Greetings valued user, if you wish to change the system of gameplay, please uncomment the lines below and comment out the corresponding
    //line. For instance, if you wish to change the type of executioner, please uncomment the other type, and comment out the type you do not wish to use
    //we hope that this experience is both enlightening and enjoyable.

    public static void main (String[] args) {
    	
    	HangmanDictionary dictionary = new HangmanDictionary(DICTIONARY);
    	
    	CheatingExecutioner executioner = new CheatingExecutioner(dictionary, NUM_LETTERS);
    	//HonestExecutioner executioner = new HonestExecutioner(dictionary,NUM_LETTERS);
    	
    	AutoGuesser guesser = new AutoGuesser(NUM_LETTERS, NUM_MISSES);
    	//ManualGuesser guesser = new ManualGuesser(NUM_LETTERS,NUM_MISSES);
    	
    	
        new HangmanGame(new HangmanDictionary(DICTIONARY), NUM_LETTERS, NUM_MISSES,executioner,guesser).play();
    }
}
